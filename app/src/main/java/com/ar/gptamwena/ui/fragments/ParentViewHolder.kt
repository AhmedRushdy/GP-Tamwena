package com.ar.gptamwena.ui.fragments

import android.view.View
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R

class ParentViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
    val recyclerView : RecyclerView = itemView.findViewById(R.id.recyclerView_item_category)
    val catName: TextView = itemView.findViewById(R.id.textViewProduct)
}