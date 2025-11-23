package com.domain.visor.school.core_executor.core.generic

import com.domain.visor.school.core_executor.core.usecase.BuildSingleUseCase
import io.reactivex.rxjava3.core.Single
import retrofit2.Response

class GenericSingleUseCase<T>(private val response: Single<Response<T>>) : BuildSingleUseCase<Response<T>>()
{
    override fun buildSingleUseCase(): Single<Response<T>>
    {
        return response
    }
}