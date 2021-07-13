package com.example.designing


import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.forlooptask.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_image_picker.*
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*
import kotlin.collections.ArrayList


class LoginActivity : AppCompatActivity() {
    var isEmailValid = false
    var isPasswordValid = false
    var isClick = false
    lateinit var auth:FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.getWindow().setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        ); //enable full screen
        setContentView(R.layout.activity_login)
        auth= FirebaseAuth.getInstance()
        onClick()
        setValidation()
        loginUser()
        gotoRegsiter()
    }

    private fun gotoRegsiter() {
        btnCreateAccount.setOnClickListener {
            btnCreateAccount.setOnClickListener {
                var createAccountIntent=Intent(this@LoginActivity, RegisterActivity::class.java)
                startActivity(createAccountIntent)
            }        }
    }

    //login user
    private fun loginUser() {
        btnLogin.setOnClickListener {
            val email=edtEmail.text.toString()
            val password=edtPassword.text.toString()
            auth.signInWithEmailAndPassword(email,password).addOnCompleteListener {
                if(it.isSuccessful)
                {
                    val dashboardIntent=Intent(this, DashBoardActivity::class.java)
                    startActivity(dashboardIntent)
                }
            }.addOnFailureListener {
                Toast.makeText(applicationContext,it.localizedMessage, Toast.LENGTH_LONG).show()
            }
        }

    }

    // to start gallery intent
    private fun onClick() {
        btnLogin.setOnClickListener {
            if (!(isEmailValid || isPasswordValid)) {
                setValidation()
            } else {
                var loginIntent = Intent(this@LoginActivity, ProfileSetupActivity::class.java)
                startActivity(loginIntent)
            }
        }


    }

    //setting validation for correct email and password
    fun setValidation() {
        if (edtEmail.getText().toString().isEmpty()) {
            edtEmail.setError(resources.getString(R.string.email_error))
            isEmailValid = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail.getText().toString()).matches()) {
            edtEmail.setError(resources.getString(R.string.error_invalid_email))
            isEmailValid = false
        } else {
            isEmailValid = true
        }

        if (edtPassword.getText().toString().isEmpty()) {
            edtPassword.setError(resources.getString(R.string.password_error))
            isPasswordValid = false
        } else if (edtPassword.getText()!!.length < 6) {
            edtPassword.setError(resources.getString(R.string.error_invalid_password))
            isPasswordValid = false
        } else {
            isPasswordValid = true
        }
        if (isEmailValid && isPasswordValid) {
            Toast.makeText(applicationContext, "Successfully", Toast.LENGTH_SHORT).show()
        }
    }


// to toggle the password
    fun ShowHidePass(view: View) {
        if (isClick) {
            edtPassword.setTransformationMethod(PasswordTransformationMethod())
            isClick = false
            imageView.setImageResource(R.drawable.show_password_icon)
        } else {
            imageView.setImageResource(R.drawable.hide_password_icon)
            isClick = true
            edtPassword.setTransformationMethod(null)

        }

    }

}
