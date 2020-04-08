package com.acceleronlabs.quark.services

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object AlertServiceBuilder {

    //Before prod deployment change this to the prod endpoint
    private const val URL = "http://10.0.2.2:8080/mdc/"

    private val OkHttpClient: OkHttpClient.Builder = okhttp3.OkHttpClient.Builder()

    private val builder =
        Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.build())

    private val retrofit = builder.build()

    fun <T> alertBuildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}