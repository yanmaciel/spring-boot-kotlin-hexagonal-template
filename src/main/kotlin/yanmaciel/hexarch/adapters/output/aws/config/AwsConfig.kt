package yanmaciel.hexarch.adapters.output.aws.config


import com.amazonaws.auth.AWSStaticCredentialsProvider
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.AmazonSQSAsyncClientBuilder
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
    fun awsCredentialsProvider(): AWSStaticCredentialsProvider =
        AWSStaticCredentialsProvider(BasicAWSCredentials(awsKey, awsSecret))

    @Bean
    fun amazonSQSAsync(awsCredentialsProvider: AWSStaticCredentialsProvider): AmazonSQSAsync =
        AmazonSQSAsyncClientBuilder.standard()
            .withCredentials(awsCredentialsProvider)
            .withEndpointConfiguration(
                AwsClientBuilder.EndpointConfiguration(awsEndpoint, awsRegion)
            )
            .build()
}