package yanmaciel.hexarch.utils

import com.fasterxml.jackson.databind.ObjectMapper


inline fun <reified T : Any> String.toObject(): T = ObjectMapper().readValue(this, T::class.java)

inline fun <reified T : Any> T.objectToJson(): String = ObjectMapper().writeValueAsString(this)
