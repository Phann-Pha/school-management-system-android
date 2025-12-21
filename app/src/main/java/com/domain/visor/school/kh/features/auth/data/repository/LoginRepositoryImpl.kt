package com.domain.visor.school.kh.features.auth.data.repository

import com.domain.visor.school.kh.features.auth.data.model.DataLoginDto
import com.domain.visor.school.kh.features.auth.domain.repository.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor() : LoginRepository
{
    override fun onUserLogin(): Response<DataLoginDto> {

    }
}