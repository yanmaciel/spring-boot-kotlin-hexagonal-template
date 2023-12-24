package yanmaciel.hexarch.adapters.output.aws.sqs.dto.converter

import yanmaciel.hexarch.adapters.output.aws.sqs.dto.CustomerStateEvent
import yanmaciel.hexarch.core.domain.model.Customer

fun Customer.toEvent(): CustomerStateEvent = with(this) {
    CustomerStateEvent(
        id = id,
        name = name,
        score = credit?.score,
        availableLimit = credit?.availableLimit
    )
}