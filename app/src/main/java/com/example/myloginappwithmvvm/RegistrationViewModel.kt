package com.example.myloginappwithmvvm

import androidx.lifecycle.ViewModel

class RegistrationViewModel(private val repository: SharedPreferenceRepository) : ViewModel() {
    // TODO: Creating method to Set the UserName, Password and CNF_Password to provide data to repository

    fun setUserName(userName: String){
        repository.setUserName(userName)
    }
    fun setPassword(password: String, cnfPassword: String){
        repository.setPassword(password, cnfPassword)
    }
    fun getUserName():String{
        return repository.getUserName()
    }
    fun getPassword(): String{
        return repository.getPassword()
    }
}