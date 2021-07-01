package com.ar.gptamwena.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R
import com.ar.gptamwena.databinding.ItemCstMainStoresBinding
import com.ar.gptamwena.models.ProductModel
import com.ar.gptamwena.models.SellerModel
import com.ar.gptamwena.ui.shopprofile.ShopProfileActivity
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar

class CustomerMainShopsAdapter() :
    RecyclerView.Adapter<CustomerMainShopsAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(val binding: ItemCstMainStoresBinding) :
        RecyclerView.ViewHolder(binding.root)
    private val differCallback = object : DiffUtil.ItemCallback<SellerModel>() {
        override fun areItemsTheSame(oldItem: SellerModel, newItem: SellerModel): Boolean {
            return oldItem.licenceNumber == newItem.licenceNumber
        }
        override fun areContentsTheSame(oldItem: SellerModel, newItem: SellerModel): Boolean {
            return oldItem == newItem
        }

    }
    val differ = AsyncListDiffer(this, differCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ItemCstMainStoresBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {

            val seller = differ.currentList[position]

            holder.binding.apply {
                itemStoreName.text = seller.marketName
                itemStoreLocation.text = seller.marketLocation
                Glide.with(root).load(seller.image).centerCrop()
                    .into(itemStorePic)
            }
            holder.itemView.apply {
                setOnClickListener {
                    onItemClickListener?.let { it(seller) }
                }
            }


    }

    private var onItemClickListener: ((SellerModel) -> Unit)? = null

    fun setOnItemClickListener(listener: (SellerModel) -> Unit) {
        onItemClickListener = listener
    }

    override fun getItemCount(): Int {

            return differ.currentList.size

    }
}

