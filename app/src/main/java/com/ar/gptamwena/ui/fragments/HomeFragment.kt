package com.ar.gptamwena.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
import com.ar.gptamwena.ui.shopprofile.ShopProfileActivity
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var sharedViewModel: SharedViewModel
    lateinit var binding: FragmentHomeBinding
    lateinit var sellerAdapter: CustomerMainShopsAdapter
    lateinit var sellerList:MutableList<SellerModel>
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
                findNavController().navigate(R.id.action_nav_home_to_near_shops)

            })
        val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
        val currentDate = sdf.format(Date())
        binding.txtCstMainDate.text =  currentDate

        sellerAdapter.setOnItemClickListener {
//
//            val bundle = Bundle().apply {
//                putSerializable("seller_object", it)
//            }
            val i = Intent(requireActivity(),ShopProfileActivity::class.java)
            i.putExtra("seller_object",it)
            startActivity(i)
        }
        var job: Job? = null

        job?.cancel()
        job = MainScope().launch {
            delay(1500)
            sellerAdapter.differ.submitList(sharedViewModel.sellerList)

        }


    }

    private fun initRecyclerView() {
        sellerAdapter = CustomerMainShopsAdapter()
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