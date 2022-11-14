package com.example.myloginappwithmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myloginappwithmvvm.databinding.ActivityRegistrationPageBinding

class RegistrationPage : AppCompatActivity() {
    private lateinit var dataBinding: ActivityRegistrationPageBinding
    private lateinit var factory: RegistrationViewModelFactory
    private lateinit var viewModel: RegistrationViewModel
    private lateinit var repository: SharedPreferenceRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_registration_page)
        factory = RegistrationViewModelFactory(SharedPreferenceRepository(this))
        viewModel = ViewModelProvider(this, factory)[RegistrationViewModel::class.java]
        repository = SharedPreferenceRepository(this)


        dataBinding.btnRegister.setOnClickListener {
            if(dataBinding.etRegUserName.text.toString().isNotEmpty()&&dataBinding.etRegPassword.text.toString().isNotEmpty()&&
                dataBinding.etRegCnfPassword.text.toString().isNotEmpty()){
                viewModel.setUserName(dataBinding.etRegUserName.text.toString())

                if(dataBinding.etRegPassword.text.toString() == dataBinding.etRegCnfPassword.text.toString()){
                    viewModel.setPassword(dataBinding.etRegPassword.text.toString(), dataBinding.etRegCnfPassword.text.toString())
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@RegistrationPage,MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
                else{
                    Toast.makeText(this, "Password Mismatch", Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(this, "Registration Incomplete", Toast.LENGTH_SHORT).show()}
        }
    }
}