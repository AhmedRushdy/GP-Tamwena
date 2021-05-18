package com.ar.gptamwena.ui.login

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineDispatcher

class LoginViewModel(private val dispatcher: CoroutineDispatcher) : ViewModel(),
    LifecycleObserver {
    private var rootNode: FirebaseDatabase
    private var customersAuthReference: DatabaseReference
    var loading: MutableLiveData<Boolean> = MutableLiveData()

    init {


        rootNode = FirebaseDatabase.getInstance()
        customersAuthReference = rootNode.getReference("customers")

        loading.postValue(false)
    }
}
