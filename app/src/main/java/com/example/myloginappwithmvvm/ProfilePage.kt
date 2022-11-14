package com.example.myloginappwithmvvm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.myloginappwithmvvm.databinding.ActivityProfilePageBinding

class ProfilePage : AppCompatActivity() {
    private lateinit var dataBinding: ActivityProfilePageBinding
    private lateinit var repository: SharedPreferenceRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding= DataBindingUtil.setContentView(this, R.layout.activity_profile_page)
        repository = SharedPreferenceRepository(this)
        dataBinding.tvWelcome.text = "Welcom"+" "+repository.getUserName()

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.profile_menu_logout, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_logout->{
                repository.setUserName("")
                repository.setPassword("","")
                val intent = Intent(this@ProfilePage, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
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