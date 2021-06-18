package com.ar.gptamwena.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.databinding.ItemCstMainProductsBinding
import com.ar.gptamwena.models.ProductModel
import com.bumptech.glide.Glide

class ProductsAdapter : RecyclerView.Adapter<ProductsAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(val binding : ItemCstMainProductsBinding) : RecyclerView.ViewHolder(binding.root)

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
            ItemCstMainProductsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = differ.currentList[position]

        holder.binding.apply {
            txtPrevNameItem.text = product.name
            try {
                Glide.with(root).load( product.image)
                    .into(imgTypeProductItem)
            } catch (e: Exception) {
                Log.i("product image", "product image not found")
            }


        }
        holder.itemView.apply {
            setOnClickListener {
                onItemClickListener?.let { it(product) }
            }
        }

    }
    private var onItemClickListener: ((ProductModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (ProductModel) -> Unit) {
        onItemClickListener = listener
    }
    override fun getItemCount(): Int {
        return differ.currentList.size
    }


}