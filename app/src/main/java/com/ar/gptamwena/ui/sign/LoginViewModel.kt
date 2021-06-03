package com.ar.gptamwena.ui.sign

import android.app.Application
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.ar.gptamwena.models.CustomerModel
import com.ar.gptamwena.ui.DrawerActivity
import com.google.firebase.database.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LoginViewModel(
    private val dispatcher: CoroutineDispatcher,
    app: Application
) : AndroidViewModel(app),
    LifecycleObserver {
    //lateinit var address: String
    lateinit var customerModel: CustomerModel
    private var rootNode: FirebaseDatabase
    lateinit var customersAuthReference: DatabaseReference
    var loading: MutableLiveData<Boolean> = MutableLiveData()
    var state = false

    init {

        rootNode = FirebaseDatabase.getInstance()
        customersAuthReference = rootNode.reference.child("customers")
        customerModel = CustomerModel("", "", "", "", "", "", "", "", "")
    }
    suspend fun getUser(context: FragmentActivity, licence: String, password: String) = withContext(Dispatchers.Default) {
        checkForUserData(context, licence, password)
    }

    suspend fun checkForUserData(context: FragmentActivity, licence: String, password: String) {

            customersAuthReference.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.child(licence).child("password").value.toString() == password) {
                    state = true
                    Toast.makeText(context, state.toString(), Toast.LENGTH_SHORT).show()
                    customerModel.cardNumber =
                        dataSnapshot.child(licence).child("cardNumber").value.toString()
                    customerModel.familyNums =
                        dataSnapshot.child(licence).child("familyNums").value.toString()
                    customerModel.cName =
                        dataSnapshot.child(licence).child("name").value.toString()
                    customerModel.cID =
                        dataSnapshot.child(licence).child("id").value.toString()
                    customerModel.cLocation =
                        dataSnapshot.child(licence).child("location").value.toString()
                    customerModel.phoneNumber =
                        dataSnapshot.child(licence).child("phone").value.toString()
                    customerModel.wallet =
                        dataSnapshot.child(licence).child("wallet").value.toString()
                    customerModel.password =
                        dataSnapshot.child(licence).child("password").value.toString()
                    customerModel.transID =
                        dataSnapshot.child(licence).child("transID").value.toString()

                    moveToNext(context)
                } else
                    Toast.makeText(context, "خطأ فى رقم البطاقة التموينية او كلمة المرور", Toast.LENGTH_LONG).show()
            }

            override fun onCancelled(error: DatabaseError) {
                // Failed to read value

            }

        })
    }


//    fun getLocation(context: Context, latitude: Double, longitude: Double) = viewModelScope.launch {
//        safeGetLocation(context, latitude, longitude)
//    }

//    private suspend fun safeGetLocation(
//        context: Context,
//        latitude: Double,
//        longitude: Double
//    ): String? {
//
//        val geocoder: Geocoder = Geocoder(context, Locale.getDefault())
//        loading.postValue(true)
//
//        val addresses: List<Address> = geocoder.getFromLocation(
//            latitude,
//            longitude,
//            1
//        ) // Here 1 represent max location result to returned, by documents it recommended 1 to 5
//
//
//        address =
//            addresses[0].getAddressLine(0) // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
//
//        val city = addresses[0].locality
//        val state = addresses[0].adminArea
//        val country = addresses[0].countryName
//        val postalCode = addresses[0].postalCode
//        val knownName = addresses[0].featureName
//        loading.postValue(false)
//        return address
//
//    }
private fun moveToNext(context: Context) {
    val intent = Intent(
        context,
        DrawerActivity::class.java
    )
    intent.putExtra("customerData",customerModel)
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
    context.startActivity(intent)
}
}