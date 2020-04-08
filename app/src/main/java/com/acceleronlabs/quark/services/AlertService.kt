package com.acceleronlabs.quark.services

import com.acceleronlabs.quark.models.AlertModel
import retrofit2.Call
import retrofit2.http.GET

interface AlertService {

    @GET("alerts")
    fun getAlert(): Call<AlertModel>
}