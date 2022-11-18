package com.example.myloginappwithmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.myloginappwithmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var dataBinding: ActivityMainBinding
    private lateinit var factory: RegistrationViewModelFactory
    private lateinit var viewModel: RegistrationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        factory = RegistrationViewModelFactory(SharedPreferenceRepository(this))
        viewModel = ViewModelProvider(this, factory)[RegistrationViewModel::class.java]

        dataBinding.btnRegLink.setOnClickListener(this)
        dataBinding.btnLogin.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        when (view!!.id) {
            R.id.btn_reg_link -> {
                val intent = Intent(this@MainActivity, RegistrationPage::class.java)
                startActivity(intent)
                finish()
            }
        }

        when (view.id) {
            R.id.btn_login -> {
                if (dataBinding.etPassword.text.toString().isNotEmpty()
                    && dataBinding.etUserName.text.toString().isNotEmpty()
                ) {
                    if (viewModel.getPassword()== "" && viewModel.getUserName() == "") {
                        Toast.makeText(this, "Complete Registration", Toast.LENGTH_SHORT).show()
                    }else if (dataBinding.etUserName.text.toString() == viewModel.getUserName() &&
                        dataBinding.etPassword.text.toString() == viewModel.getPassword()
                    ) {
                        val intent = Intent(this@MainActivity, ProfilePage::class.java)
                        startActivity(intent)
                        finish()
                    }
                    else if (dataBinding.etUserName.text.toString()!= viewModel.getUserName()) {
                        Toast.makeText(this, "Invalid username", Toast.LENGTH_SHORT).show()
                    }else if (dataBinding.etPassword.text.toString() != viewModel.getPassword()) {
                        Toast.makeText(this, "Invalid password", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    (Toast.makeText(this, "userName and Password required", Toast.LENGTH_SHORT)
                        .show())
                }
            }
        }
    }
    override fun onBackPressed() {
        val alertdialog : AlertDialog = AlertDialog.Builder(this).create()
        alertdialog.setMessage("Do you want to exit")

        alertdialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes"){
                dialog, which-> finish()
            dialog.dismiss()}
        alertdialog.setButton(AlertDialog.BUTTON_NEGATIVE,"No"){
                dialog, which->
            dialog.dismiss()
        }
        alertdialog.show()
    }
}