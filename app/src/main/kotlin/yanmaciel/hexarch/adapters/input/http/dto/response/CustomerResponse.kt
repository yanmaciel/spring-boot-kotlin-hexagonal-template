package yanmaciel.hexarch.adapters.input.http.dto.response

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(SnakeCaseStrategy::class)
data class CustomerResponse(
    val name: String,
    val score: Int? = null,
    val availableLimit: Double? = null
)
