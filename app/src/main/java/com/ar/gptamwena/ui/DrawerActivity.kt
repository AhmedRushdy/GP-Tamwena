package com.ar.gptamwena.ui

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ar.gptamwena.R
import com.ar.gptamwena.databinding.ActivityDrawerBinding
import com.ar.gptamwena.models.CustomerModel
import com.ar.gptamwena.ui.shopprofile.BuyProcessActivity

class DrawerActivity : AppCompatActivity() {
    lateinit var customerObject : CustomerModel
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityDrawerBinding
    lateinit var viewModel: SharedViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initViewModel()
        binding = ActivityDrawerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarDrawer.drawerToolbar)
//        binding.appBarDrawer.imageView2.setOnClickListener {
//            var i = Intent(this, BuyProcessActivity::class.java)
//            startActivity(i)
//        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        customerObject = intent.extras?.get("customerData") as CustomerModel

        viewModel.customerModel = customerObject

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_drawer)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.near_shops, R.id.nav_shopping_history,R.id.nav_my_account
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_drawer)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    private fun initViewModel(){
        var loginViewModelProvider = SharedViewModelProvider()
        viewModel = ViewModelProvider(this,loginViewModelProvider).get(SharedViewModel::class.java)
    }
}