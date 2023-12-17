package yanmaciel.hexarch.core.domain.service

import org.springframework.stereotype.Service
import yanmaciel.hexarch.core.port.output.CreditScoreOutputPort
import yanmaciel.hexarch.core.port.output.CustomerRepositoryOutputPort

@Service
class CustomerServiceImpl(
    private val creditScoreOutputPort: CreditScoreOutputPort,
    private val customerRepositoryOutputPort: CustomerRepositoryOutputPort
) {
}