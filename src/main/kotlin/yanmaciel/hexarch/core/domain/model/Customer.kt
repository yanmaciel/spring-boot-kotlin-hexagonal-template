package yanmaciel.hexarch.core.domain.model

data class Customer(
    val id: String,
    val name: String,
    val credit: Credit? = null
)
