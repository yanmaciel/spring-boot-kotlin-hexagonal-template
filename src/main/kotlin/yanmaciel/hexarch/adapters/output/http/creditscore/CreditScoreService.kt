package yanmaciel.hexarch.adapters.output.http.creditscore

import org.springframework.stereotype.Service
import yanmaciel.hexarch.core.port.output.CreditScorePort
import kotlin.random.Random

@Service
class CreditScoreService : CreditScorePort {
    override fun getScore(customerId: String): Int = Random.nextInt(0, 1001)
}