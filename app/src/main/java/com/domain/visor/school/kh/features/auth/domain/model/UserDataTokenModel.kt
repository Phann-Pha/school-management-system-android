package com.domain.visor.school.kh.features.auth.domain.model

data class UserDataTokenModel(
    val tokenType: String? = "",

    val accessToken: String? = "",
    val expiresIn: Int? = 0,

    val refreshToken: String? = "",
    val refreshExpiresIn: String? = "",
)