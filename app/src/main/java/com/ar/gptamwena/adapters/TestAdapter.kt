package com.ar.gptamwena.adapters

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.models.ParentModel


class TestAdapter (private val itemList: List<ParentModel>) :
    RecyclerView.Adapter<TestAdapter.ParentViewHolder?>() {
    // An object of RecyclerView.RecycledViewPool
    // is created to share the Views
    // between the child and
    // the parent RecyclerViews
    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TestAdapter.ParentViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(com.ar.gptamwena.R.layout.products_li_item,parent,false)
        return TestAdapter.ParentViewHolder(v)
    }

    override fun onBindViewHolder(
        parentViewHolder: ParentViewHolder,
        position: Int
    ) {

        val parentItem: ParentModel = itemList[position]

        parentViewHolder.textView.text = parentItem.name

        val layoutManager = LinearLayoutManager(
            parentViewHolder.recyclerView
                .context,
            LinearLayoutManager.HORIZONTAL,
            false
        )

        // Since this is a nested layout, so
        // to define how many child items
        // should be prefetched when the
        // child RecyclerView is nested
        // inside the parent RecyclerView,
        // we use the following method
        layoutManager.initialPrefetchItemCount = parentItem.ProductList!!.size

        // Create an instance of the child
        // item view adapter and set its
        // adapter, layout manager and RecyclerViewPool
//        val childItemAdapter = ProductsAdapter()
//        childItemAdapter.differ.submitList(parentItem.ProductList)
//        parentViewHolder.recyclerView.layoutManager = layoutManager
//        parentViewHolder.recyclerView.adapter = childItemAdapter
//        parentViewHolder.recyclerView
//            .setRecycledViewPool(viewPool)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }


    class ParentViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val recyclerView : RecyclerView = itemView.findViewById(com.ar.gptamwena.R.id.recyclerView_item_category)
        val textView:TextView = itemView.findViewById(com.ar.gptamwena.R.id.textViewProduct)
    }

}