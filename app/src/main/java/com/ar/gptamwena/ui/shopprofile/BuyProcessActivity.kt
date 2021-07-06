package com.ar.gptamwena.ui.shopprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.ar.gptamwena.R
import com.ar.gptamwena.models.CustomerModel
import com.ar.gptamwena.models.ProductModel
import com.ar.gptamwena.ui.SharedViewModel
import com.ar.gptamwena.ui.SharedViewModelProvider
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class BuyProcessActivity : AppCompatActivity() {
    lateinit var viewModel : SharedViewModel
    var productCartList = mutableListOf<ProductModel>()
    var totalPrice: Float = 0.0F
    lateinit var customer:CustomerModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_process)
        initViewModel()
        customer = intent.getSerializableExtra("customerlic") as CustomerModel
        viewModel.customerModel = customer
        readCart(customer.cardNumber)

    }
    private fun initViewModel(){
        var loginViewModelProvider = SharedViewModelProvider()
        viewModel = ViewModelProvider(this,loginViewModelProvider).get(SharedViewModel::class.java)
    }
    fun readCart(currentCustomerLic: String) {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("cart").child(currentCustomerLic)

        val productListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    val productModel = ProductModel(
                        postSnapshot.child("id").value.toString(),
                        postSnapshot.child("name").value.toString(),
                        postSnapshot.child("image").value.toString(),
                        postSnapshot.child("price").value.toString(),
                        postSnapshot.child("quantity").value.toString()
                    )
                    productCartList.add(productModel)
                    totalPrice += productModel.price.toInt()

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        }
        myRef.addValueEventListener(productListener)

    }


}