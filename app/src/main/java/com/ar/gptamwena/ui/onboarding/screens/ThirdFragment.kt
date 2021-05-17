package com.ar.gptamwena.ui.onboarding.screens

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ar.gptamwena.ui.MainActivity2
import com.ar.gptamwena.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    lateinit var binding: FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(layoutInflater,container,false)
        val view = binding.root

        binding.finish.setOnClickListener {
            val intent = Intent(requireContext(), MainActivity2::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            onBoardingFinish()
        }
        return view
    }

    private fun onBoardingFinish(){
        val sharedpref = requireActivity().getSharedPreferences("onBoarding",Context.MODE_PRIVATE)
        val editor = sharedpref.edit()
        editor.putBoolean("Finished",true)
        editor.apply()
    }

}