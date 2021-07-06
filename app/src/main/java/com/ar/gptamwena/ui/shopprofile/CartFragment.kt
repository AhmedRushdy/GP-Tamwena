package com.ar.gptamwena.ui.shopprofile

import android.content.Intent.getIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R
import com.ar.gptamwena.adapters.CartAdapter
import com.ar.gptamwena.databinding.FragmentCartBinding
import com.ar.gptamwena.models.ProductModel
import com.ar.gptamwena.ui.SharedViewModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CartFragment : Fragment() {
    lateinit var binding: FragmentCartBinding
    lateinit var adapter: CartAdapter
    var productCartList = mutableListOf<ProductModel>()
        override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCartBinding.inflate(layoutInflater, container, false)
        initRV()
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button2.setOnClickListener {
            findNavController().navigate(
                R.id.action_cartFragment_to_finishOrderFragment,
            )
        }
        var job: Job? = null
        job?.cancel()
        job = MainScope().launch {
            delay(1000)
            adapter.differ.submitList((activity as BuyProcessActivity).productCartList)
            binding.tvTotalPrice.text = (activity as BuyProcessActivity).totalPrice.toString()

        }
    }

    private fun initRV() {
        adapter = CartAdapter()
        binding.recyclerView3.adapter = adapter
        binding.recyclerView3.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
    }



}