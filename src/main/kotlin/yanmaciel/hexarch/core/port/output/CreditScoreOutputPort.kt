package yanmaciel.hexarch.core.port.output

interface CreditScoreOutputPort {
    fun getScore(customerId: String): Int
}