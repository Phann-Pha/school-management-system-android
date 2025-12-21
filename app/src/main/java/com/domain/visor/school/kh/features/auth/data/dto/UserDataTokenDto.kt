package com.domain.visor.school.kh.features.auth.data.dto

import com.domain.visor.school.kh.features.auth.domain.model.UserDataTokenModel
import kotlinx.serialization.SerialName

data class UserDataTokenDto(

    @SerialName("tokenType")
    val tokenType: String? = "",

    @SerialName("accessToken")
    val accessToken: String? = "",

    @SerialName("expiresIn")
    val expiresIn: Int? = 0,

    @SerialName("refreshToken")
    val refreshToken: String? = "",

    @SerialName("refreshExpiresIn")
    val refreshExpiresIn: String? = "",
)
{
    fun toUserDataTokenModel(): UserDataTokenModel
    {
        return UserDataTokenModel(
            tokenType = tokenType,
            accessToken = accessToken,
            expiresIn = expiresIn,
            refreshToken = refreshToken,
            refreshExpiresIn = refreshExpiresIn,
        )
    }
}