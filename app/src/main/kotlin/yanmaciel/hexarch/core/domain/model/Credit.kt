package yanmaciel.hexarch.core.domain.model

data class Credit(
    val score: Int
) {
    val availableLimit: Double
        get() = when {
            score >= 800 -> 20000.00
            score in 700..799 -> 15000.00
            score in 580..699 -> 5000.00
            else -> 1500.00
        }
}
