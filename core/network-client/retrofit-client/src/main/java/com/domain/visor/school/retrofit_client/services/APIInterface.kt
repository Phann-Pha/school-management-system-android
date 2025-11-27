package com.domain.visor.school.retrofit_client.services

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface APIInterface {

    @GET(value = "path/to/endpoint")
    suspend fun onGetUser(): Response<ResponseBody>
}