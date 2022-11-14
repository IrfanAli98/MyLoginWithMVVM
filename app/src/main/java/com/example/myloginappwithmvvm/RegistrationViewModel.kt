package com.example.myloginappwithmvvm

import androidx.lifecycle.ViewModel

class RegistrationViewModel(val repository: SharedPreferenceRepository) : ViewModel() {
    // TODO: Creating method to Set the UserName, Password and CNF_Password to provide data to repository mehtod

    fun setUserName(userName: String){
        repository.setUserName(userName)
    }
    fun setPassword(password: String, cnfPassword: String){
        repository.setPassword(password, cnfPassword)
    }
}