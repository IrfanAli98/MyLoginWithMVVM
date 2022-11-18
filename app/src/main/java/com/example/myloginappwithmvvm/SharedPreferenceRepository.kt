package com.example.myloginappwithmvvm

import android.content.Context

// TODO: Used context to create the shared preference out of the Activity 
class SharedPreferenceRepository(context: Context) {

    // TODO: Custom shared Preference 
    private val sharedPref = context.getSharedPreferences(Keys.Shared_Pref, Context.MODE_PRIVATE)

    // TODO: Creating the editor Object so that we can edit the shared Preference 
    private val editor = sharedPref.edit()

    // TODO: Methods created to set the value of userName, password and cnfPassword to Shared Preference
    fun setUserName(userName: String){
        editor.putString(Keys.userName, userName)
        editor.commit()
    }
    fun setPassword(password: String, cnfPassword: String){
        editor.putString(Keys.password, password)
        editor.putString(Keys.cnfPassword, cnfPassword)
        editor.commit()
    }


    // TODO: Methods Created to get the UserName and Password
    fun getUserName(): String{
        return sharedPref.getString(Keys.userName,"").toString()
    }
    fun getPassword(): String{
        return sharedPref.getString(Keys.password,"").toString()
    }

}