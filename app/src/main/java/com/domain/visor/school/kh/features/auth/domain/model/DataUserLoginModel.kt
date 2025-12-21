package com.domain.visor.school.kh.features.auth.domain.model

data class DataUserLoginModel(
    val status: Boolean? = false,
    val data: UserDataTokenModel? = UserDataTokenModel(),

    val message: String? = "",
    val timestamp: String? = ""
)