package com.ar.gptamwena.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R
import com.ar.gptamwena.adapters.CustomerMainShopsAdapter
import com.ar.gptamwena.ui.DrawerActivity
import com.ar.gptamwena.ui.SharedViewModel

class NearShopsFragment : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_near_shops, container, false)
    }

    private var shoShopsRV: RecyclerView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = (activity as DrawerActivity).viewModel

        shoShopsRV = view.findViewById(R.id.rv_cst_show_shops)
        shoShopsRV?.adapter = CustomerMainShopsAdapter()
        shoShopsRV?.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)


    }

}