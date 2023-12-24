package yanmaciel.hexarch.core.domain.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import yanmaciel.hexarch.core.domain.model.Credit
import yanmaciel.hexarch.core.domain.model.Customer
import yanmaciel.hexarch.core.port.input.GetCustomerUseCase
import yanmaciel.hexarch.core.port.input.SaveCustomerUseCase
import yanmaciel.hexarch.core.port.output.CreditScorePort
import yanmaciel.hexarch.core.port.output.CustomerRepositoryPort
import yanmaciel.hexarch.core.port.output.CustomerStateMessagePort

@Service
class CustomerService(
    private val creditScorePort: CreditScorePort,
    private val customerRepositoryPort: CustomerRepositoryPort,
    private val customerStateMessagePort: CustomerStateMessagePort
) : GetCustomerUseCase, SaveCustomerUseCase {

    override fun getById(customerId: String): Customer = customerRepositoryPort.getById(customerId)

    override fun save(customer: Customer): Customer =
        customerRepositoryPort.save(customer.apply { credit = Credit(creditScorePort.getScore(id)) })
            .also {
                customerStateMessagePort.send(customer)
            }
}