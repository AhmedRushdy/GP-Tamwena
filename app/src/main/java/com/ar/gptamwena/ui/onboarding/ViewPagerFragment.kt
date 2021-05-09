package com.graduationproject.paginationtest.ui.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.graduationproject.paginationtest.databinding.FragmentViewPagerBinding
import com.graduationproject.paginationtest.ui.onboarding.screens.FirstFragment
import com.graduationproject.paginationtest.ui.onboarding.screens.SecondFragment
import com.graduationproject.samples.onboarding.ViewPagerAdapter
import com.graduationproject.samples.onboarding.screans.ThirdFragment

class ViewPagerFragment : Fragment() {
    private lateinit var binding: FragmentViewPagerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentViewPagerBinding.inflate(layoutInflater)
        val view = binding.root
        val fragmentList = arrayListOf<Fragment>(
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