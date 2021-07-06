package com.ar.gptamwena.ui.shopprofile

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R
import com.ar.gptamwena.adapters.CartAdapter
import com.ar.gptamwena.adapters.FinalProcessAdapter
import com.ar.gptamwena.databinding.FragmentFinishOrderBinding
import com.ar.gptamwena.databinding.OrderItemBinding
import com.ar.gptamwena.models.CustomerModel
import com.google.firebase.database.*

class FinishOrderFragment : Fragment() {
    lateinit var adapter: FinalProcessAdapter
    lateinit var binding: FragmentFinishOrderBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFinishOrderBinding.inflate(layoutInflater, container, false)
        initRV()

        adapter.differ.submitList((activity as BuyProcessActivity).productCartList)
        binding.totalPrice.text = (activity as BuyProcessActivity).totalPrice.toString()
        binding.customerName.text = (activity as BuyProcessActivity).customer.cName
        binding.customerLicence.text =(activity as BuyProcessActivity).customer.cardNumber
        binding.customerAddress.text = (activity as BuyProcessActivity).customer.cLocation
        return binding.root
    }

    private fun initRV() {
        adapter = FinalProcessAdapter()
        binding.finalProductsList.adapter = adapter
        binding.finalProductsList.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
    }


}