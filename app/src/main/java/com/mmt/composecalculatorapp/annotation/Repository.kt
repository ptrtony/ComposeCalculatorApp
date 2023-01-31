package com.mmt.composecalculatorapp.annotation

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Repository {
    private val api by lazy {
        Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(AuthInterceptor())
                    .addInterceptor(HttpLoggingInterceptor()
                        .setLevel(level = HttpLoggingInterceptor.Level.BODY)
                    )
                    .build()
            )
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(MyApi::class.java)
    }
}