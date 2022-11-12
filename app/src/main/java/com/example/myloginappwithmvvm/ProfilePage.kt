package com.example.myloginappwithmvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.myloginappwithmvvm.databinding.ActivityProfilePageBinding

class ProfilePage : AppCompatActivity() {
    private lateinit var dataBinding: ActivityProfilePageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding= DataBindingUtil.setContentView(this, R.layout.activity_profile_page)
    }
}