package com.ar.gptamwena.ui.onboarding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

import com.ar.gptamwena.R
import com.ar.gptamwena.ui.DrawerActivity
import com.ar.gptamwena.ui.sign.SignActivity

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        val handler = Handler()
        handler.postDelayed({
            val intent = Intent(this@StartActivity, SignActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000)

    }
    }
