package com.ar.gptamwena.adapters

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R

class ProductViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){
    val productImg : ImageView = itemView.findViewById(R.id.img_type_product_item)
    val productName: TextView = itemView.findViewById(R.id.txt_prev_name_item)
    val productPrice: TextView = itemView.findViewById(R.id.txt_prev_price_item)
    val addToCart: Button = itemView.findViewById(R.id.add)

}