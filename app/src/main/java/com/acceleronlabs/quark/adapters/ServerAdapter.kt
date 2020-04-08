package com.acceleronlabs.quark.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.acceleronlabs.quark.R
import com.acceleronlabs.quark.activities.AlertActivity
import com.acceleronlabs.quark.helpers.AppConstants
import com.acceleronlabs.quark.models.MDCServer
import kotlinx.android.synthetic.main.list_item.view.*


class ServerAdapter(val context: Context, val servers: List<MDCServer>) :
    RecyclerView.Adapter<ServerAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var currServer: String? = null
        var currPosition: Int? = 0

        init {
            itemView.setOnClickListener {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
            }

            itemView.btnAlert.setOnClickListener {

                val getServerName: String = this.currServer.toString()
                val intent = Intent(
                    context,
                    AlertActivity::class.java
                )
                intent.putExtra(AppConstants.SERVER_NAME, getServerName)
                context.startActivity(intent)
            }
        }

        fun setData(server: MDCServer?, pos: Int) {
            itemView.txvTitle.text = server?.name
            this.currServer = server?.name
            this.currPosition = pos
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return servers.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val server = servers[position]
        holder.setData(server, position)
    }


}