package yanmaciel.hexarch.adapters.output.aws.sns.dto

import yanmaciel.hexarch.utils.getTimestamp

private const val CUSTOMER_STATE_EVENT_TYPE = "CUSTOMER_STATE"

data class CustomerStateEvent(
    val timestamp: String = getTimestamp(),
    val type: String = CUSTOMER_STATE_EVENT_TYPE,
    val id: String,
    val name: String,
    val score: Int? = null,
    val availableLimit: Double? = null
)
