package com.example.letschat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {
    private lateinit var  edtEmail: EditText
    private lateinit var  edtPassord: EditText
    private lateinit var  edtLogin: Button
    private lateinit var  edtSignup: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        edtEmail = findViewById(R.id.edt_email)
        edtPassord = findViewById(R.id.edt_password)
        edtLogin = findViewById(R.id.btn_login)
        edtSignup = findViewById(R.id.btn_signup)



        edtSignup.setOnClickListener {
            val intent =  Intent(this, Signup::class.java)
            startActivity(intent)
        }
    }
}