package com.graduationproject.paginationtest.ui.onboarding

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.graduationproject.paginationtest.ui.MainActivity2
import com.graduationproject.paginationtest.R

class SplashFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler().postDelayed({
            if (obBoardingCheck()) {
                val intent = Intent(requireContext(), MainActivity2::class.java)
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent)
            } else {
                findNavController().navigate(R.id.action_splashFragment_to_viewPagerFragment)

            }

        }, 3000)
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    private fun obBoardingCheck(): Boolean {
        val sharedpref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedpref.getBoolean("Finished", false)
    }
}
