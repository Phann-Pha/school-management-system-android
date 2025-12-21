package com.domain.visor.school.kh.features.auth.domain.repository

import okhttp3.ResponseBody
import retrofit2.Response

interface LoginUserAccountRepository
{
    suspend fun onLoginUserAccount(email: String, password: String): Response<ResponseBody>
}