package com.ar.gptamwena.ui.sign

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ar.gptamwena.R
import com.ar.gptamwena.databinding.FragmentSplashLoginBinding
import com.ar.gptamwena.ui.DrawerActivity
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashLoginFragment : Fragment() {
    var confirmType: Button? = null
    private lateinit var viewModel: LoginViewModel
    lateinit var binding: FragmentSplashLoginBinding
    var checkState = false
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSplashLoginBinding.inflate(layoutInflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as SignActivity).loginViewModel
        binding.btnLogin.setOnClickListener(View.OnClickListener {
            lifecycleScope.launch {
                viewModel.getUser(
                    requireActivity(),
                    binding.signUpPhoneNumber.text.toString(),
                    binding.password.text.toString()
                )

            }
        })
    }


}