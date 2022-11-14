package com.example.myloginappwithmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.myloginappwithmvvm.databinding.ActivityFleshScreenBinding

class FleshScreen : AppCompatActivity() {
    private lateinit var dataBinding:ActivityFleshScreenBinding
    private lateinit var repository: SharedPreferenceRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this,R.layout.activity_flesh_screen)
        repository = SharedPreferenceRepository(this)

        dataBinding.progressBar.visibility = View.VISIBLE

        if (repository.getUserName().isNotEmpty()&&repository.getPassword().isNotEmpty()){
            val intent = Intent(this, ProfilePage::class.java )
            startActivity(intent)
            finish()
        }
        else{
            val intent = Intent(this, MainActivity::class.java )
            startActivity(intent)
            finish()
        }
    }
}