package yanmaciel.hexarch.adapters.output.aws.dynamo

import org.springframework.stereotype.Service
import yanmaciel.hexarch.core.domain.model.Credit
import yanmaciel.hexarch.core.domain.model.Customer
import yanmaciel.hexarch.core.port.output.CustomerRepositoryOutputPort

@Service
class CustomerRepositoryService : CustomerRepositoryOutputPort {
    override fun getById(customerId: String): Customer =
        Customer(
            id = "id",
            name = "Yan",
            credit = Credit(score = 800)
        )

    override fun save(customer: Customer): Customer = customer
}