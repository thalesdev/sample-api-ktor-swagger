package io.example.dto

import kotlinx.serialization.Serializable


@Serializable
sealed interface HealthDTOInterface {
    val uptime: Long
    @Serializable
    data class HealthDTO(
        override val uptime: Long,
        val database: Boolean?
    ) : HealthDTOInterface
    @Serializable
    data class healthDTO2(
        override val uptime: Long
    ) : HealthDTOInterface
}



@Serializable
data class ErrorResponse(
    val message: String,
    val code: Int
)
