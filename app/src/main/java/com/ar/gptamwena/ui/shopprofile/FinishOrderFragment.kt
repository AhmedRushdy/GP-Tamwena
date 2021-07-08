package com.ar.gptamwena.ui.shopprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R
import com.ar.gptamwena.adapters.FinalProcessAdapter
import com.ar.gptamwena.databinding.FragmentFinishOrderBinding
import com.ar.gptamwena.models.TransactionModel
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*

class FinishOrderFragment : Fragment() {
    lateinit var adapter: FinalProcessAdapter
    lateinit var binding: FragmentFinishOrderBinding
    lateinit var key:String
    lateinit var transaction: TransactionModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFinishOrderBinding.inflate(layoutInflater, container, false)
        initRV()
        val sdf = SimpleDateFormat("dd/M/yyyy HH:mm:ss")
        val currentDate = sdf.format(Date())

        adapter.differ.submitList((activity as BuyProcessActivity).productCartList)
        binding.totalPrice.text = (activity as BuyProcessActivity).totalPrice.toString()
        binding.customerName.text = (activity as BuyProcessActivity).customer.cName
        binding.customerLicence.text =(activity as BuyProcessActivity).customer.cardNumber
        binding.customerAddress.text = (activity as BuyProcessActivity).customer.cLocation

        binding.confirm.setOnClickListener {
            writeTrans(currentDate)
            findNavController().navigate(R.id.action_finishOrderFragment_to_lastFragment)
        }
        return binding.root
    }

    private fun writeTrans(currentDate:String) {
            val database = FirebaseDatabase.getInstance()
            key = database.getReference("transactions").push().key.toString()
            transaction = TransactionModel((activity as BuyProcessActivity).customer.cID,
            (activity as BuyProcessActivity).seller.licenceNumber,
            (activity as BuyProcessActivity).totalPrice.toString(),
            currentDate,
            key
            )
            val myRef = database.getReference("transactions").push()
                myRef.setValue(transaction)
            writeList(key)
            }

    private fun writeList(key: String) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("transaction_products").child((activity as BuyProcessActivity).customer.cID)
        for (product in (activity as BuyProcessActivity).productCartList.iterator()) {
            myRef.push().setValue(product)
        }
    }


    private fun initRV() {
        adapter = FinalProcessAdapter()
        binding.finalProductsList.adapter = adapter
        binding.finalProductsList.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
    }


}