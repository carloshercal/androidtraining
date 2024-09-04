package com.iescm.androidtraining.features.login.presentation

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.iescm.androidtraining.R
import com.iescm.androidtraining.features.login.LoginFactory

class LoginActivity : AppCompatActivity() {

    private lateinit var loginFactory : LoginFactory
    private lateinit var loginViewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginFactory = LoginFactory()
        loginViewModel = loginFactory.provideLoginViewModel()
        setContentView(R.layout.activity_login)
        setupView()
    }

    private fun setupView() {
        val actionValidate = findViewById<Button>(R.id.action_validate)
        actionValidate.setOnClickListener {
            Log.d("@dev","Clicked!!")
            val userName = findViewById<EditText>(R.id.input_username).text.toString()
            val password = findViewById<EditText>(R.id.input_password).text.toString()
            val isValid = loginViewModel.validateClicked(userName,password)

            if(isValid){
                Snackbar.make(findViewById(R.id.main), R.string.message_login_ok, Snackbar.LENGTH_SHORT)
            } else{
                Snackbar.make(findViewById(R.id.main), R.string.message_login_fail, Snackbar.LENGTH_SHORT)
            }.show()
        }
    }
}