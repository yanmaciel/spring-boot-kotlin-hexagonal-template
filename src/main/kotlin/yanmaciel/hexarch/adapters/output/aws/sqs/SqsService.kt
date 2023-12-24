package yanmaciel.hexarch.adapters.output.aws.sqs

import com.amazonaws.services.sqs.AmazonSQSAsync
import com.amazonaws.services.sqs.model.SendMessageRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import yanmaciel.hexarch.adapters.output.aws.sqs.dto.converter.toEvent
import yanmaciel.hexarch.core.domain.model.Customer
import yanmaciel.hexarch.core.port.output.CustomerStateMessagePort
import yanmaciel.hexarch.utils.objectToJson

@Service
class SqsService(
    @Value("\${aws.sqs.queueName}")
    private val sqsQueueName: String,
    private val amazonSQSAsync: AmazonSQSAsync
) : CustomerStateMessagePort {

    private val logger = LoggerFactory.getLogger(this::class.java)

    override fun send(customer: Customer) {

        val queueUrl: String = amazonSQSAsync.getQueueUrl(sqsQueueName).queueUrl
        val messageBody: String = customer.toEvent().objectToJson()

        val sendMessageRequest = SendMessageRequest()
            .withQueueUrl(queueUrl)
            .withMessageBody(messageBody)

        val response = amazonSQSAsync.sendMessage(sendMessageRequest)

        logger.info("Message ${response.messageId} sent out to queue $sqsQueueName. Body: $messageBody")
    }
}