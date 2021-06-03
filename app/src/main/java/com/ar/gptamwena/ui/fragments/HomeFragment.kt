package com.ar.gptamwena.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.adapters.CustomerMainProductsAdapter
import com.ar.gptamwena.adapters.CustomerMainShopsAdapter
import com.ar.gptamwena.databinding.FragmentHomeBinding
import com.ar.gptamwena.ui.CustomerShowShopsActivity
import com.ar.gptamwena.ui.DrawerActivity
import com.ar.gptamwena.ui.SharedViewModel

class HomeFragment : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel
    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel = (activity as DrawerActivity).viewModel

        initRecyclerView()

        binding.btnCstMainShowAll.setOnClickListener(
            View.OnClickListener {
                startActivity(
                    Intent(
                        requireContext(),
                        CustomerShowShopsActivity::class.java
                    )
                )
            })
    }

    private fun initRecyclerView() {
        binding.rvCstMainCategories.adapter = CustomerMainProductsAdapter()
        binding.rvCstMainCategories.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rvCstMainShops.adapter = CustomerMainShopsAdapter()
        binding.rvCstMainShops.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rvCstMainBought.adapter = CustomerMainProductsAdapter()
        binding.rvCstMainBought.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }
}