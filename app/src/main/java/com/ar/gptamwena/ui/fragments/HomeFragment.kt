package com.ar.gptamwena.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R
import com.ar.gptamwena.adapters.CustomerMainProductsAdapter
import com.ar.gptamwena.adapters.CustomerMainShopsAdapter
import com.ar.gptamwena.databinding.FragmentHomeBinding
import com.ar.gptamwena.models.SellerModel
import com.ar.gptamwena.ui.DrawerActivity
import com.ar.gptamwena.ui.SharedViewModel
import com.google.firebase.database.FirebaseDatabase

class HomeFragment : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel
    lateinit var binding: FragmentHomeBinding
    lateinit var sellerAdapter: CustomerMainShopsAdapter
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

        sellerAdapter.differ.submitList(sharedViewModel.sellerList)
        binding.btnCstMainShowAll.setOnClickListener(
            View.OnClickListener {
                findNavController().navigate(R.id.action_nav_home_to_near_shops)

            })


        sellerAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("seller_object", it)

            }
            findNavController().navigate(
                R.id.action_nav_home_to_productsFragment,
                bundle
            )
        }


    }
    fun getshops(){
        var sellerList = mutableListOf<SellerModel>()

        val sellerDatabase = FirebaseDatabase.getInstance()
        sellerDatabase.getReference("sellers").get().addOnSuccessListener {
            for (postSnapshot in it.children) {
                var sellerModel = SellerModel(
                    postSnapshot.child("licenceNumber").value.toString(),
                    postSnapshot.child("marketLocation").value.toString(),
                    postSnapshot.child("marketName").value.toString(),
                    postSnapshot.child("nationalID").value.toString(),
                    postSnapshot.child("ownerName").value.toString(),
                    postSnapshot.child("phoneNumber").value.toString()
                )

                sellerList.add(sellerModel)
            }
        }
        sellerAdapter.differ.submitList(sellerList)

    }
    private fun initRecyclerView() {
        sellerAdapter = CustomerMainShopsAdapter("home")
        binding.rvCstMainCategories.adapter = CustomerMainProductsAdapter()
        binding.rvCstMainCategories.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)

        binding.rvCstMainShops.adapter = sellerAdapter

        binding.rvCstMainShops.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.rvCstMainBought.adapter = CustomerMainProductsAdapter()
        binding.rvCstMainBought.layoutManager =
            LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
    }
}