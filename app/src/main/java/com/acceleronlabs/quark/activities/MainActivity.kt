package com.acceleronlabs.quark.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.acceleronlabs.quark.R
import com.acceleronlabs.quark.adapters.ServerAdapter
import com.acceleronlabs.quark.models.Supplier
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager

        val adapter = ServerAdapter(this, Supplier.servers)
        recyclerView.adapter = adapter

    }
}
