package yanmaciel.hexarch.adapters.output.aws.sqs

import aws.sdk.kotlin.services.sqs.SqsClient
import aws.sdk.kotlin.services.sqs.model.GetQueueUrlRequest
import aws.sdk.kotlin.services.sqs.model.SendMessageRequest
import com.fasterxml.jackson.databind.ObjectMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import yanmaciel.hexarch.adapters.output.aws.sqs.dto.converter.toEvent
import yanmaciel.hexarch.core.domain.model.Customer
import yanmaciel.hexarch.core.port.output.CustomerStateMessagePort
import yanmaciel.hexarch.utils.exception.BusinessException

@Service
class SqsService(
    @Value("\${aws.sqs.queueName}")
    private val sqsQueueName: String,
    private val sqsClient: SqsClient,
    private val objectMapper: ObjectMapper
) : CustomerStateMessagePort {

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
        const val DELAY_IN_SECONDS = 1
    }

    override fun send(customer: Customer) {
        //val getQueueUrl = getQueueUrl(sqsQueueName)

        val sendMessageRequest = SendMessageRequest {
            queueUrl = "http://localhost:4566/000000000000/customer-state-queue"
            delaySeconds = DELAY_IN_SECONDS
            messageBody = objectMapper.writeValueAsString(customer)
        }

        runBlocking { sqsClient.sendMessage(sendMessageRequest) }
    }

    suspend fun getQueueUrl(queueNameVal: String): String? {
        val getQueueUrlRequest = GetQueueUrlRequest {
            queueName = queueNameVal
        }

        val getQueueUrlResponse = withContext(Dispatchers.IO) {
            try {
                sqsClient.getQueueUrl(getQueueUrlRequest)
            } catch (_: Exception) {
                null
            }
        }
        return getQueueUrlResponse?.queueUrl
    }
}