package com.domain.visor.school.kh.features.auth.data.dto

import com.domain.visor.school.kh.features.auth.domain.model.DataUserLoginModel
import kotlinx.serialization.SerialName

data class DataUserLoginDto(
    @SerialName("success")
    val status: Boolean? = false,

    @SerialName("data")
    val data: UserDataTokenDto? = UserDataTokenDto(),

    @SerialName("message")
    val message: String? = "",

    @SerialName("timestamp")
    val timestamp: String? = ""
)
{
    fun toDataUserLogin(): DataUserLoginModel
    {
        return DataUserLoginModel(
            status = status,
            data = data?.toUserDataTokenModel(),
            message = message,
            timestamp = timestamp
        )
    }
}