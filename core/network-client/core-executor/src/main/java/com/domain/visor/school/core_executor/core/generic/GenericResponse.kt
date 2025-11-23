package com.domain.visor.school.core_executor.core.generic

import com.domain.visor.school.core_executor.helper.Resource
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GenericResponse<T>(private val builder: GenericSingleUseCase<T>) {
    suspend fun execute(): Resource<T> {
        return suspendCoroutine { continuation ->
            try {
                builder.execute(
                    success = { response ->
                        continuation.resume(
                            value = Resource.Success(
                                data = response.body(),
                                code = response.code().toString(),
                                message = response.message(),
                                url = response.raw().request.url.toString()
                            )
                        )
                    },
                    error = { throwable ->
                        continuation.resume(value = Resource.Error(message = throwable.message, throwable = throwable))
                    }
                )
            } catch (throwable: Throwable) {
                continuation.resume(value = Resource.Error(message = throwable.message, throwable = throwable))
            }
        }
    }
}