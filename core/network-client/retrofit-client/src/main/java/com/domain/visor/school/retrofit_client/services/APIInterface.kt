package com.domain.visor.school.retrofit_client.services

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface APIInterface
{
    @POST("auth/login")
    @Headers("Content-Type: application/json")
    suspend fun onLoginUserAccount(@Body user: User): Response<ResponseBody>
}

data class User(
    val email: String,
    val password: String
)