package yanmaciel.hexarch.core.port.output

import yanmaciel.hexarch.core.domain.model.Customer

interface CustomerStateMessagePort {
    fun send(customer: Customer): Unit
}