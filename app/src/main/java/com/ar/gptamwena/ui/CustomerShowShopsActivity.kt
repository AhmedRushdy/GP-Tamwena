package com.ar.gptamwena.ui
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ar.gptamwena.R
import com.ar.gptamwena.adapters.CustomerMainShopsAdapter

class CustomerShowShopsActivity : AppCompatActivity() {

    private var shoShopsRV: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer_show_shops)

        shoShopsRV = findViewById(R.id.rv_cst_show_shops)
        shoShopsRV?.adapter = CustomerMainShopsAdapter()
        shoShopsRV?.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
  }
}