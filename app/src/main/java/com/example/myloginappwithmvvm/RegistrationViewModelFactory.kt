package com.example.myloginappwithmvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class RegistrationViewModelFactory(val repository: SharedPreferenceRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegistrationViewModel::class.java)){
            return RegistrationViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown Class")
    }
}