package yanmaciel.hexarch.adapters.output.aws.sns

import org.springframework.stereotype.Service
import yanmaciel.hexarch.adapters.output.aws.sns.dto.converter.toEvent
import yanmaciel.hexarch.core.domain.model.Customer
import yanmaciel.hexarch.core.port.output.CustomerStateMessagePort

@Service
class SnsService : CustomerStateMessagePort {
    override fun send(customer: Customer) = println(customer.toEvent())
}