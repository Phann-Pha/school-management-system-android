package com.domain.visor.school.retrofit_client.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class HttpInterceptor : Interceptor
{
    override fun intercept(chain: Interceptor.Chain): Response
    {
        val request = chain.request()
        val response = chain.proceed(request)

        return response
    }
}