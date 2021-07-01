package com.ar.gptamwena.ui

import android.util.Log
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.ar.gptamwena.models.CustomerModel
import com.ar.gptamwena.models.ProductModel
import com.ar.gptamwena.models.SellerModel
import com.google.firebase.database.*
import kotlinx.coroutines.CoroutineDispatcher


class SharedViewModel(private val dispatcher: CoroutineDispatcher) : ViewModel(),
    LifecycleObserver {
    lateinit var customerModel: CustomerModel
    lateinit var productsReference: DatabaseReference
    lateinit var sellerReference: DatabaseReference
    var productsDatabase: FirebaseDatabase
    var sellerList: MutableList<SellerModel> = mutableListOf()
    var productsCartList: MutableList<ProductModel> = mutableListOf()
    var riceList: MutableList<ProductModel> = mutableListOf()
    var oilList: MutableList<ProductModel> = mutableListOf()
    var pastaList: MutableList<ProductModel> = mutableListOf()
    var sugarList: MutableList<ProductModel> = mutableListOf()
    var currentCustomerLic: String = ""
    private lateinit var sellerDatabase: FirebaseDatabase

    init {
        productsDatabase = FirebaseDatabase.getInstance()
        sellerDatabase = FirebaseDatabase.getInstance()
        getSellers()

//        getSellerTest()
    }


    fun getSellers() {
        sellerReference = sellerDatabase.getReference("sellers")
        val sellerListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    var sellerModel: SellerModel = SellerModel(
                        postSnapshot.child("licenceNumber").value.toString(),
                        postSnapshot.child("marketLocation").value.toString(),
                        postSnapshot.child("marketName").value.toString(),
                        postSnapshot.child("nationalID").value.toString(),
                        postSnapshot.child("ownerName").value.toString(),
                        postSnapshot.child("phoneNumber").value.toString(),
                        postSnapshot.child("image").value.toString()

                    )

                    sellerList.add(sellerModel)
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("2222", "loadPost:onCancelled", databaseError.toException())
            }
        }
        sellerReference.addValueEventListener(sellerListener)

    }

    fun addToCart(product: ProductModel) {
        productsCartList.add(product)
    }

    fun getProducts(licence: String, productsCat: String) {
        currentCustomerLic = licence
        productsReference =
            productsDatabase.getReference("products").child(licence).child(productsCat)
        val productListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                for (postSnapshot in dataSnapshot.children) {
                    val productModel = ProductModel(
                        postSnapshot.child("id").value.toString(),
                        postSnapshot.child("name").value.toString(),
                        postSnapshot.child("image").value.toString(),
                        postSnapshot.child("quantity").value.toString(),
                        postSnapshot.child("cost").value.toString()
                    )
                    when (productsCat) {
                        "pasta" -> pastaList.add(productModel)
                        "oil" -> oilList.add(productModel)
                        "rice" -> riceList.add(productModel)
                        "sugar" -> sugarList.add(productModel)
                    }
                }

            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message
                Log.w("2222", "loadPost:onCancelled", databaseError.toException())
            }
        }
        productsReference.addValueEventListener(productListener)
    }

    fun writeProductList() {
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("cart").child(currentCustomerLic)
        for (product in productsCartList.iterator()) {
            myRef.push().setValue(product)
        }

    }


}
