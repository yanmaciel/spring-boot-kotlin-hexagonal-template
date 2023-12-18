package yanmaciel.hexarch.adapters.output.http.creditscore

import org.springframework.stereotype.Service
import yanmaciel.hexarch.core.port.output.CreditScoreOutputPort

@Service
class CreditScoreService : CreditScoreOutputPort {
    override fun getScore(customerId: String): Int = 800
}