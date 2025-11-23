package com.domain.visor.school.core_executor.helper

sealed class Resource<T> (
    val data: T? = null,
    val code: String? = "",
    val message: String? = "",
    val url: String? = "",
    val throwable: Throwable? = null
) {
    class Success<T>(
        data: T? = null,
        code: String? = "",
        message: String? = "",
        url: String? = "",
        throwable: Throwable? = null
    ) : Resource<T>(
        data = data,
        code = code,
        message = message,
        url = url,
        throwable = throwable
    )

    class Error<T>(
        data: T? = null,
        code: String? = "",
        message: String? = "",
        url: String? = "",
        throwable: Throwable? = null
    ) : Resource<T>(
        data = data,
        code = code,
        message = message,
        url = url,
        throwable = throwable
    )
}