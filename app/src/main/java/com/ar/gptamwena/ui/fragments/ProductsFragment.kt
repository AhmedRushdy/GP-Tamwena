package com.ar.gptamwena.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R
import com.ar.gptamwena.adapters.CustomerMainProductsAdapter
import com.ar.gptamwena.adapters.ParentAdapter

class ProductsFragment : Fragment() {

    private var productsFragmentRV: RecyclerView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_product, container, false)

            productsFragmentRV = view.findViewById(R.id.parent_recyclerView)
        productsFragmentRV?.adapter = ParentAdapter()
        productsFragmentRV?.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
        return view
    }

}