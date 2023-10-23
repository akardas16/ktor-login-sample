package com.login.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginRequestData(
    val email: String,
    val password: String
)

@Serializable
data class LoginResponseData(
    val id: String,
    val email: String,
)