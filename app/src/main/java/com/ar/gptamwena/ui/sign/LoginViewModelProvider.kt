package com.ar.gptamwena.ui.sign

import android.app.Application
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import androidx.lifecycle.ViewModelProvider

class LoginViewModelProvider(val app : Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {

            return LoginViewModel(Dispatchers.IO,app ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }}