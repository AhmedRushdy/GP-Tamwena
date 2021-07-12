package com.ar.gptamwena.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R
import com.ar.gptamwena.adapters.CustomerMainShopsAdapter
import com.ar.gptamwena.databinding.FragmentNearShopsBinding
import com.ar.gptamwena.ui.DrawerActivity
import com.ar.gptamwena.ui.SharedViewModel
import com.ar.gptamwena.ui.shopprofile.ShopProfileActivity

class NearShopsFragment : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel
    lateinit var binding : FragmentNearShopsBinding
    private lateinit var adapter:CustomerMainShopsAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNearShopsBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = (activity as DrawerActivity).viewModel

        initRV()

        adapter.differ.submitList(sharedViewModel.sellerList)
        adapter.setOnItemClickListener {
            val i = Intent(requireActivity(), ShopProfileActivity::class.java)
            i.putExtra("seller_object", it)
            i.putExtra("customerObject", (activity as DrawerActivity).customerObject)
            startActivity(i)
        }
    }

    private fun initRV() {
        adapter = CustomerMainShopsAdapter()
        binding.rvCstShowShops.adapter = adapter
        binding.rvCstShowShops.layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
    }

}