package com.example.myloginappwithmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.myloginappwithmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var dataBinding: ActivityMainBinding
    lateinit var repository: SharedPreferenceRepository
    private lateinit var factory: RegistrationViewModelFactory
    private lateinit var viewModel: RegistrationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        dataBinding.btnRegLink.setOnClickListener(this)
        dataBinding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_reg_link -> {
                val intent = Intent(this@MainActivity, RegistrationPage::class.java)
                startActivity(intent)
            }
        }

        when (view!!.id) {
            R.id.btn_login -> {
                if (dataBinding.etPassword.text.toString()
                        .isNotEmpty() && dataBinding.etUserName.text.toString().isNotEmpty()
                ) {
                    if (repository.getPassword() == "" && repository.getUserName() == "") {
                        Toast.makeText(this, "Complete Registration", Toast.LENGTH_SHORT).show()
                    } else if (dataBinding.etUserName.text.toString() == repository.getUserName() &&
                        dataBinding.etPassword.text.toString() == repository.getPassword()
                    ) {
                        val intent = Intent(this@MainActivity, ProfilePage::class.java)
                    }
                } else {(Toast.makeText(this, "userName and Password required", Toast.LENGTH_SHORT).show())}
            }
        }
    }
}