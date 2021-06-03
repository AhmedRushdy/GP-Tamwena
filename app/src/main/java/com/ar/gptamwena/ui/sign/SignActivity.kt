package com.ar.gptamwena.ui.sign

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.ar.gptamwena.R
import androidx.lifecycle.ViewModelProvider

class SignActivity : AppCompatActivity() {
    private var splashVideo: VideoView? = null
    lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)

        initViewModel()


        splashVideo = findViewById<View>(R.id.splash_vid) as VideoView
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.splashvid)
        splashVideo!!.setVideoURI(uri)
        fragment = SplashPlaceFragment()
        supportFragmentManager.beginTransaction().replace(
            R.id.splash_frame,
            fragment!!
        ).commit()
    }

    private fun initViewModel() {
        var loginViewModelProvider = LoginViewModelProvider(application)
        loginViewModel =
            ViewModelProvider(this, loginViewModelProvider).get(LoginViewModel::class.java)
    }


    override fun onResume() {
        super.onResume()
        splashVideo!!.setOnCompletionListener { mediaPlayer -> mediaPlayer.start() }
        splashVideo!!.start()
    }

    companion object {
        var fragment: Fragment? = null
    }
}