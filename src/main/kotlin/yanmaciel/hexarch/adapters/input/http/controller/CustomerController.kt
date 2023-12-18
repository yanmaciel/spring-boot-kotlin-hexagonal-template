package yanmaciel.hexarch.adapters.input.http.controller

import org.springframework.web.bind.annotation.*
import yanmaciel.hexarch.adapters.input.http.dto.converter.toDomain
import yanmaciel.hexarch.adapters.input.http.dto.converter.toResponse
import yanmaciel.hexarch.adapters.input.http.dto.request.CustomerRequest
import yanmaciel.hexarch.adapters.input.http.dto.response.CustomerResponse
import yanmaciel.hexarch.core.domain.service.CustomerService

@RestController
@RequestMapping("/v1/customer")
class CustomerController(
    private val customerService: CustomerService
) {

    @PostMapping
    fun save(@RequestBody customerRequest: CustomerRequest): CustomerResponse =
        customerService.save(customerRequest.toDomain()).toResponse()

    @GetMapping("/{customerId}")
    fun getById(@PathVariable customerId: String): CustomerResponse =
        customerService.getById(customerId).toResponse()
}