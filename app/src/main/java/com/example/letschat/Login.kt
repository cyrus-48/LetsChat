package com.example.letschat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class Login : AppCompatActivity() {
    private lateinit var  edtEmail: EditText
    private lateinit var  edtPassord: EditText
    private lateinit var  edtLogin: Button
    private lateinit var  edtSignup: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        edtEmail = findViewById(R.id.edt_email)
        edtPassord = findViewById(R.id.edt_password)
        edtLogin = findViewById(R.id.btn_login)
        edtSignup = findViewById(R.id.btn_signup)



        edtSignup.setOnClickListener {
            val intent =  Intent(this, Signup::class.java)
            startActivity(intent)
        }

        edtLogin.setOnClickListener(){

            val email = edtEmail.text.toString()
            val password = edtPassord.text.toString()
            login(email , password)
        }
    }
    private  fun login(email: String , password: String){
        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this@Login , MainActivity::class.java)
                    startActivity(intent)

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@Login , "User does not Exist", Toast.LENGTH_LONG).show()

                }
            }


    }
}