package com.ar.gptamwena.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ar.gptamwena.databinding.FragmentMyAccountBinding
import com.ar.gptamwena.ui.DrawerActivity
import com.ar.gptamwena.ui.SharedViewModel

class MyAccountFragment : Fragment() {
    lateinit var viewModel: SharedViewModel
    lateinit var binding:FragmentMyAccountBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMyAccountBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as DrawerActivity).viewModel
//
//        binding.cCard.text = viewModel.customerModel.cardNumber
//        binding.cName.text = viewModel.customerModel.cName
//
//        binding.logOutBtn.setOnClickListener {
//            requireActivity().startActivity(Intent(requireActivity(),SignActivity::class.java))
//        }
    }

}