package yanmaciel.hexarch.core.port.output

interface CreditScorePort {
    fun getScore(customerId: String): Int
}