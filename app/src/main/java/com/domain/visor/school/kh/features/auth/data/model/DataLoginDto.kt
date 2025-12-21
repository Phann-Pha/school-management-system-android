package com.domain.visor.school.kh.features.auth.data.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class DataLoginDto(
    @SerializedName("status") val status: String?,
    @SerializedName("code") val code: String?,
    @SerializedName("msg") val msg: String?,
    @SerializedName("tokenID") val tokenID: String?
)
