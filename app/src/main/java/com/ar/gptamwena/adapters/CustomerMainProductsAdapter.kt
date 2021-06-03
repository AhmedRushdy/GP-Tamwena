package com.ar.gptamwena.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R

class CustomerMainProductsAdapter :
    RecyclerView.Adapter<CustomerMainProductsAdapter.CVMPViewHolder>() {
    inner class CVMPViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVMPViewHolder {
        return CVMPViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_cst_main_products, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CVMPViewHolder, position: Int) {}
    override fun getItemCount(): Int {
        return 5
    }
}

