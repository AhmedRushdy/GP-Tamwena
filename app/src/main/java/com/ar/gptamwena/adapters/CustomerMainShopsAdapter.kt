package com.ar.gptamwena.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R

class CustomerMainShopsAdapter : RecyclerView.Adapter<CustomerMainShopsAdapter.CVMSViewHolder>() {
    inner class CVMSViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVMSViewHolder {
        return CVMSViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cst_main_stores, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CVMSViewHolder, position: Int) {
//        holder.itemView.setOnClickListener { view ->
//            view.context.startActivity(
//                Intent(
//                    view.context,
//                    CustomerShopProfileActivity::class.java
//                )
//            )
//        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}

