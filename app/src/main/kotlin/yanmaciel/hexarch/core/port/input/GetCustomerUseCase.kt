package yanmaciel.hexarch.core.port.input

import yanmaciel.hexarch.core.domain.model.Customer

interface GetCustomerUseCase {
    fun getById(customerId: String): Customer
}