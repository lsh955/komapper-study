package dto

import org.komapper.annotation.*
import java.time.LocalDateTime

@KomapperEntity
data class Employee(
    @KomapperId
    @KomapperAutoIncrement
    val id: Int = 0,
    val name: String,
    @KomapperVersion
    val version: Int = 0,
    @KomapperCreatedAt
    val createdAt: LocalDateTime = LocalDateTime.MIN,
    @KomapperCreatedAt
    val updatedAt: LocalDateTime = LocalDateTime.MIN
)
