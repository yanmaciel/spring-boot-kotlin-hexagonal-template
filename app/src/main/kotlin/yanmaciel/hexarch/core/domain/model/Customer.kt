package yanmaciel.hexarch.core.domain.model

data class Customer(
    val id: String,
    val name: String,
    var credit: Credit? = null
)
