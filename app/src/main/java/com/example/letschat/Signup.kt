package com.example.letschat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Signup : AppCompatActivity() {
    private  lateinit var  edtName: EditText
    private lateinit var  edtEmail: EditText
    private lateinit var  edtPassord: EditText
    private lateinit var  edtSignup: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        edtEmail = findViewById(R.id.edt_email)
        edtPassord = findViewById(R.id.edt_password)
         edtName  = findViewById(R.id.edt_name)
        edtSignup = findViewById(R.id.btn_signup)
         mAuth = FirebaseAuth.getInstance()
         edtSignup.setOnClickListener(){

            val email = edtEmail.text.toString()
            val password = edtPassord.toString()
             signup(email , password)
        }

    }
    private  fun signup(email: String , password: String){
        mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this@Signup , Login::class.java)
                    startActivity(intent)
                    Toast.makeText(this@Signup , " User created successfully", Toast.LENGTH_LONG).show()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this@Signup , "An erro occurred", Toast.LENGTH_LONG).show()

                }
            }

    }
}