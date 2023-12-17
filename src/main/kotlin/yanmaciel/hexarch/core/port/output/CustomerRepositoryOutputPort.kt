package yanmaciel.hexarch.core.port.output

import yanmaciel.hexarch.core.domain.model.Customer

interface CustomerRepositoryOutputPort {
    fun getById(customerId: String): Customer

    fun save(customer: Customer): Customer
}