package com.ar.gptamwena.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.ar.gptamwena.R
import com.ar.gptamwena.models.ParentModel



class ParentAdapter : RecyclerView.Adapter<ParentAdapter.ViewHolder>(){
    private val viewPool = RecyclerView.RecycledViewPool()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.products_li_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return 5
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.recyclerView.apply {
            layoutManager = LinearLayoutManager(holder.recyclerView.context, RecyclerView.HORIZONTAL, false)
            adapter = CustomerMainProductsAdapter()
            setRecycledViewPool(viewPool)

        }
    }


    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.findViewById(R.id.recyclerView_item_category)
        val textView:TextView = itemView.findViewById(R.id.textViewProduct)
    }
}