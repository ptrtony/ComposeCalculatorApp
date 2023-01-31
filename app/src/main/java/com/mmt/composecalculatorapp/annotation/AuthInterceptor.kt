package com.mmt.composecalculatorapp.annotation

import okhttp3.Interceptor
import okhttp3.Response
import retrofit2.Invocation

class AuthInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val invocation = chain.request().tag(Invocation::class.java)?: return chain.proceed(chain.request())

        val shouldAttachedAuthHeader = invocation
            .method()
            .annotations
            .any { annotation ->
                annotation.annotationClass == Authenticated::class
            }
        return if (shouldAttachedAuthHeader) {
            chain.proceed(chain.request()
                .newBuilder()
                .addHeader("Authorization", "my token")
                .build()
            )
        } else {
            chain.proceed(chain.request())
        }
    }
}