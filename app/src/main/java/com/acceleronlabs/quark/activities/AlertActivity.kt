package com.acceleronlabs.quark.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.acceleronlabs.quark.R
import com.acceleronlabs.quark.helpers.AppConstants
import com.acceleronlabs.quark.models.AlertModel
import com.acceleronlabs.quark.services.AlertService
import com.acceleronlabs.quark.services.AlertServiceBuilder
import kotlinx.android.synthetic.main.activity_alert.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AlertActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)

        val bundle: Bundle? = intent.extras
        val serverName = bundle!!.getString(AppConstants.SERVER_NAME)
        textServerName.text = serverName

        val alertService = AlertServiceBuilder.alertBuildService(AlertService::class.java)
        val requestCall = alertService.getAlert()

        requestCall.enqueue(object : Callback<AlertModel> {
            override fun onFailure(call: Call<AlertModel>?, t: Throwable?) {
                Toast.makeText(applicationContext, "Network Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<AlertModel>?,
                response: Response<AlertModel>?
            ) {
                if (response!!.isSuccessful) {
                    val alert = response.body()
                    progressBarTemp.progress = alert.temperature!!

                }
            }

        })
    }
}
