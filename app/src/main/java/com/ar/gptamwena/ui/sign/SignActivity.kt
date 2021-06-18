package com.ar.gptamwena.ui.sign

import android.net.Uri
import android.os.Bundle
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
        binding.splashVid.setVideoURI(uri)
        fragment = SplashPlaceFragment()
        supportFragmentManager.beginTransaction().replace(
            R.id.fragment_frame,
            fragment!!
        ).commit()
    }

    private fun initViewModel() {
        val loginViewModelProvider = LoginViewModelProvider(application)
        loginViewModel =
            ViewModelProvider(this, loginViewModelProvider).get(LoginViewModel::class.java)
    }


    override fun onResume() {
        super.onResume()
        binding.splashVid.setOnCompletionListener { mediaPlayer -> mediaPlayer.start() }
        binding.splashVid.start()
    }

    companion object {
        var fragment: Fragment? = null
    }
}