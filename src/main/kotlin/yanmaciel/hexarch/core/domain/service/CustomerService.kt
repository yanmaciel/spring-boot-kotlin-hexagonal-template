package yanmaciel.hexarch.core.domain.service

import org.springframework.stereotype.Service
import yanmaciel.hexarch.core.domain.model.Credit
import yanmaciel.hexarch.core.domain.model.Customer
import yanmaciel.hexarch.core.port.input.GetCustomerUseCase
import yanmaciel.hexarch.core.port.input.SaveCustomerUseCase
import yanmaciel.hexarch.core.port.output.CreditScoreOutputPort
import yanmaciel.hexarch.core.port.output.CustomerRepositoryOutputPort

@Service
class CustomerService(
    private val creditScoreOutputPort: CreditScoreOutputPort,
    private val customerRepositoryOutputPort: CustomerRepositoryOutputPort
) : GetCustomerUseCase, SaveCustomerUseCase {

    override fun getById(customerId: String): Customer = customerRepositoryOutputPort.getById(customerId)

    override fun save(customer: Customer): Customer =
        customerRepositoryOutputPort.save(customer.apply { credit = Credit(creditScoreOutputPort.getScore(id)) })
}