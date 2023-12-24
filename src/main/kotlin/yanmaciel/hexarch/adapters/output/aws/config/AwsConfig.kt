package yanmaciel.hexarch.adapters.output.aws.config

import aws.sdk.kotlin.runtime.auth.credentials.EnvironmentCredentialsProvider
import aws.sdk.kotlin.runtime.auth.credentials.StaticCredentialsProvider
import aws.sdk.kotlin.services.sqs.SqsClient
import aws.smithy.kotlin.runtime.auth.awscredentials.CachedCredentialsProvider
import aws.smithy.kotlin.runtime.auth.awscredentials.Credentials
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProvider
import aws.smithy.kotlin.runtime.auth.awscredentials.CredentialsProviderChain
import aws.smithy.kotlin.runtime.client.LogMode
import aws.smithy.kotlin.runtime.net.url.Url
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AwsConfig(
    @Value("\${aws.accessKeyId}")
    private val awsKey: String,
    @Value("\${aws.secretAccessKey}")
    private val awsSecret: String,
    @Value("\${aws.region}")
    private val awsRegion: String,
    @Value("\${aws.endpoint}")
    private val awsEndpoint: String
) {

    @Bean
    fun awsCredentialsProvider(): CredentialsProvider {
        val chain = CredentialsProviderChain(
            EnvironmentCredentialsProvider(),
            StaticCredentialsProvider(
                Credentials(
                    secretAccessKey = awsKey,
                    accessKeyId = awsSecret
                )
            )
        )

        return CachedCredentialsProvider(chain)
    }

    @Bean
    fun sqsClient(awsCredentialsProvider: CredentialsProvider): SqsClient =
            SqsClient {
                credentialsProvider = awsCredentialsProvider
                region = awsRegion
                endpointUrl = Url.parse(awsEndpoint)
                logMode = LogMode.LogRequestWithBody
            }
}