package com.ar.gptamwena.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ar.gptamwena.R
import com.ar.gptamwena.databinding.FragmentDetailMsactivityBinding
import com.ar.gptamwena.ui.DrawerActivity
import com.ar.gptamwena.ui.SharedViewModel

class DetailMSFragment : Fragment() {
    lateinit var binding: FragmentDetailMsactivityBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailMsactivityBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.continueService.setOnClickListener {
//            findNavController().navigate(R.id.action_detailMSFragment_to_finalMSFragment)
            requireActivity().startActivity(Intent(requireActivity(), FinalMSFragment::class.java))
        }
    }
}