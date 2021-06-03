package com.ar.gptamwena.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ar.gptamwena.databinding.FragmentViewPagerBinding
import com.ar.gptamwena.ui.onboarding.screens.FirstFragment
import com.ar.gptamwena.ui.onboarding.screens.SecondFragment
import com.ar.gptamwena.ui.onboarding.screens.ThirdFragment

class ViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(layoutInflater)
        val view = binding.root
        val fragmentList = arrayListOf(
            FirstFragment(), SecondFragment(), ThirdFragment()
        )


        val adapter = ViewPagerAdapter(
            requireActivity().supportFragmentManager,
            lifecycle,
            fragmentList
        )
        binding.onboardViewpager.adapter = adapter
        return view
    }


}