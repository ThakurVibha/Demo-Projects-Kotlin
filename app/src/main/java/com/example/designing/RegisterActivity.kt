package com.example.designing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.forlooptask.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    lateinit var auth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        auth= FirebaseAuth.getInstance()
        regsiterUser()
        gotoLogin()
    }

    private fun gotoLogin() {
        textViewLogin.setOnClickListener {
            val loginIntent=Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }

    private fun regsiterUser() {
        btnRegister.setOnClickListener {
            val email=registerEmail.text.toString()
            val password=regsiterPassword.text.toString()
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener { task ->
                if(task.isSuccessful){
                    val intent= Intent(this,DashBoardActivity::class.java)
                    startActivity(intent)
                    finish()
                }

            }.addOnFailureListener {
                Toast.makeText(applicationContext,it.localizedMessage,Toast.LENGTH_LONG).show()

            }
        }

    }
}