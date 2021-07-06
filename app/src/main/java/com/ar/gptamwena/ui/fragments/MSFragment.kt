package com.ar.gptamwena.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ar.gptamwena.R
import com.ar.gptamwena.databinding.FragmentMSBinding


class MSFragment : Fragment() {
    lateinit var binding: FragmentMSBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMSBinding.inflate(layoutInflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.c1.setOnClickListener {
            findNavController().navigate(R.id.action_MSFragment_to_detailMSFragment)
        }
        binding.c2.setOnClickListener {
            findNavController().navigate(R.id.action_MSFragment_to_detailMSFragment)
        }
        binding.c3.setOnClickListener {
            findNavController().navigate(R.id.action_MSFragment_to_detailMSFragment)
        }
        binding.c4.setOnClickListener {
            findNavController().navigate(R.id.action_MSFragment_to_detailMSFragment)
        }
        binding.c5.setOnClickListener {
            findNavController().navigate(R.id.action_MSFragment_to_detailMSFragment)
        }
        binding.c6.setOnClickListener {
            findNavController().navigate(R.id.action_MSFragment_to_detailMSFragment)
        }
        binding.c7.setOnClickListener {
            findNavController().navigate(R.id.action_MSFragment_to_detailMSFragment)
        }


    }
}