package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var data: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        data=Firebase.auth
        var email=findViewById<EditText>(R.id.idEmail)
        var pass=findViewById<EditText>(R.id.idPassword)
        var button=findViewById<Button>(R.id.idBtn)
        button.setOnClickListener {
            data.createUserWithEmailAndPassword(email.text.toString(),pass.text.toString())
                .addOnSuccessListener {
                    Toast.makeText(this,"SignUp successfully",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this,loginActivity::class.java))
                }
                .addOnFailureListener {
                    Toast.makeText(this,it.message,Toast.LENGTH_SHORT).show()
                }
        }

    }
}