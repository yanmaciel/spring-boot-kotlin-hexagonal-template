package yanmaciel.hexarch.adapters.input.http.dto.response

data class CustomerResponse(
    val id: String,
    val name: String,
    val score: Int? = null,
    val availableLimit: Double? = null
)
