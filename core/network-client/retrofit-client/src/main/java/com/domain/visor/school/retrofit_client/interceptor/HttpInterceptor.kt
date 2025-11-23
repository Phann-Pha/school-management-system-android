package com.domain.visor.school.retrofit_client.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import retrofit2.Invocation

class HttpInterceptor(private val authKey: String = "", private val authValue: String = "") : Interceptor {
    @Retention(value = AnnotationRetention.RUNTIME)
    @Target(AnnotationTarget.FUNCTION)
    annotation class Authorized

    override fun intercept(chain: Interceptor.Chain): Response
    {
        var request = chain.request()
        val invocation = chain.request().tag(type = Invocation::class.java) ?: return chain.proceed(request = chain.request())
        containedOnInvocation(invocation).forEach { annotation ->
            request = onHandleAnnotation(annotation = annotation, request = request, key = authKey, value = authValue)
        }
        return chain.proceed(request)
    }

    private fun containedOnInvocation(invocation: Invocation): Set<Annotation>
    {
        return invocation.method().annotations.toSet()
    }

    private fun onHandleAnnotation(annotation: Annotation, request: Request, key: String, value: String): Request
    {
        return when (annotation)
        {
            is Authorized -> addAuthHeader(request = request, key = key, value = value)
            else -> request
        }
    }

    private fun addAuthHeader(request: Request, key: String, value: String): Request
    {
        return request.newBuilder()
            .addHeader(name = key, value = value)
            .build()
    }
}