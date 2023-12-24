package yanmaciel.hexarch.core.port.input

import yanmaciel.hexarch.core.domain.model.Customer

interface SaveCustomerUseCase {
    fun save(customer: Customer): Customer
}