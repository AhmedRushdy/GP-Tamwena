package com.ar.gptamwena.ui

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.CoroutineDispatcher

class SharedViewModel(private val dispatcher: CoroutineDispatcher) : ViewModel(),
    LifecycleObserver {


    init {

    }
}