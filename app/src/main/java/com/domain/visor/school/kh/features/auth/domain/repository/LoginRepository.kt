package com.domain.visor.school.kh.features.auth.domain.repository

import com.domain.visor.school.retrofit_client.services.User
import okhttp3.ResponseBody
import retrofit2.Response

interface LoginRepository {
    suspend fun onUserLogin(user: User): Response<ResponseBody>
}