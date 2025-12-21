package com.domain.visor.school.kh.features.auth.domain.repository

import com.domain.visor.school.core_executor.helper.Resource
import com.domain.visor.school.kh.features.auth.data.model.DataLoginDto

interface LoginRepository {
    fun onUserLogin(): Response<DataLoginDto>
}