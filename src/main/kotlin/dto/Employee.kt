package dto

import org.komapper.annotation.*
import java.time.LocalDateTime

@KomapperEntity
data class Employee(
    @KomapperId
    @KomapperAutoIncrement
    val id: Int = 0,

    val name: String, // 성함.

    @KomapperVersion
    val version: Int = 0, // 버전

    @KomapperCreatedAt
    val createdAt: LocalDateTime = LocalDateTime.MIN, // 생성일시

    @KomapperUpdatedAt
    val updatedAt: LocalDateTime = LocalDateTime.MIN // 변경일시
)