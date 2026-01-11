package com.domain.visor.school.kh.features.auth.domain.model

data class DataLoginModel(
    val status: Boolean? = false,
    val data: UserDataTokenModel? = UserDataTokenModel(),
    val message: String? = "",
    val timestamp: String? = ""
)
