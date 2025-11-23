package com.domain.visor.school.retrofit_client.provider

import com.domain.visor.school.retrofit_client.interceptor.HttpInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

@Module
@InstallIn(SingletonComponent::class)
class HttpClientProvider
{
    @Provides
    fun okHttpClient(): OkHttpClient = OkHttpClient().newBuilder()
        .readTimeout(timeout = 60, unit = TimeUnit.SECONDS)
        .writeTimeout(timeout = 60, unit = TimeUnit.SECONDS)
        .connectTimeout(timeout = 60, unit = TimeUnit.SECONDS)
        .addInterceptor(interceptor = HttpInterceptor())
        .build()
}