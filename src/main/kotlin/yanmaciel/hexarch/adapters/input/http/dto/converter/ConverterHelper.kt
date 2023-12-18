package yanmaciel.hexarch.adapters.input.http.dto.converter

import yanmaciel.hexarch.adapters.input.http.dto.request.CustomerRequest
import yanmaciel.hexarch.adapters.input.http.dto.response.CustomerResponse
import yanmaciel.hexarch.core.domain.model.Customer

fun CustomerRequest.toDomain() = with(this) {
    Customer(id = id, name = name)
}

fun Customer.toResponse() = with(this) {
    CustomerResponse(
        id = id,
        name = name,
        score = credit?.score,
        availableLimit = credit?.availableLimit
    )
}