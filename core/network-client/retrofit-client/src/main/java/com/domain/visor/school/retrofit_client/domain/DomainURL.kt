package com.domain.visor.school.retrofit_client.domain

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainURL
{
    @Provides
    fun baseURL(): String
    {
        return if (BuildConfig.IS_PRODUCTION) BuildConfig.URL_PRODUCTION else BuildConfig.URL_UAT
    }
}