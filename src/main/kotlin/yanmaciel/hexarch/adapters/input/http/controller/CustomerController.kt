package yanmaciel.hexarch.adapters.input.http.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import yanmaciel.hexarch.core.domain.model.Customer
import yanmaciel.hexarch.core.domain.service.CustomerService
import yanmaciel.hexarch.core.port.input.GetCustomerUseCase
import yanmaciel.hexarch.core.port.input.SaveCustomerUseCase

@RestController
@RequestMapping("/v1/customer")
class CustomerController(
    private val customerService: CustomerService
) : GetCustomerUseCase, SaveCustomerUseCase {

    override fun getById(customerId: String): Customer = customerService.

    override fun save(customer: Customer): Customer {
        TODO("Not yet implemented")
    }
}