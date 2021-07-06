package com.ar.gptamwena.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.databinding.OrderDetailsItemBinding
import com.ar.gptamwena.databinding.OrderItemBinding
import com.ar.gptamwena.models.ProductModel
import com.bumptech.glide.Glide

class FinalProcessAdapter : RecyclerView.Adapter<FinalProcessAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(val binding : OrderDetailsItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val differCallback = object : DiffUtil.ItemCallback<ProductModel>() {
        override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            OrderDetailsItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = differ.currentList[position]

        holder.binding.apply {
            tvOrderItemName.text = product.name
            tvOrderItemNum.text = "1"
            tvOrderItemPrice.text = product.price

        }


    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }}
