package com.mmt.composecalculatorapp.annotation

import retrofit2.http.GET

interface MyApi {

    @GET("request/v1")
    fun requestOne()

    @GET("request/v2")
    @Authenticated
    fun requestTwo()
}


@Target(AnnotationTarget.FUNCTION)
annotation class Authenticated()