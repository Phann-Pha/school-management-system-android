package com.domain.visor.school.kh.features.auth.data.model

import androidx.annotation.Keep
import kotlinx.serialization.SerialName

@Keep
data class DataLoginDto(
    @SerialName("status") val status: String?,
    @SerialName("code") val code: String?,
    @SerialName("msg") val msg: String?,
    @SerialName("tokenID") val tokenID: String?
)
