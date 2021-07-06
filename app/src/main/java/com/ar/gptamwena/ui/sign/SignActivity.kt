package com.ar.gptamwena.ui.sign

import android.net.Uri
import android.os.Bundle
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ar.gptamwena.R
import androidx.lifecycle.ViewModelProvider
import com.ar.gptamwena.databinding.ActivitySignCustomerBinding

class SignActivity : AppCompatActivity() {
    lateinit var loginViewModel: LoginViewModel
    lateinit var binding: ActivitySignCustomerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignCustomerBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initViewModel()

        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.splashvid)
        binding.vidSplashScreen.setVideoURI(uri)
    }

    private fun initViewModel() {
        val loginViewModelProvider = LoginViewModelProvider(application)
        loginViewModel =
            ViewModelProvider(this, loginViewModelProvider).get(LoginViewModel::class.java)
    }


    override fun onResume() {
        super.onResume()
        binding.vidSplashScreen.setOnCompletionListener { mediaPlayer -> mediaPlayer.start() }
        binding.vidSplashScreen.start()
    }

    companion object {
        var fragment: Fragment? = null
    }
}