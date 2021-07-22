package com.example.cloudmessaging
import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.forlooptask.R
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.notification_layout.*

class MainActivity :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClick()
    }

    @SuppressLint("StringFormatInvalid")
    private fun onClick() {
        getToken.setOnClickListener {
            // 1
            FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.w(TAG, "Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }
                // Get new FCM registration token
                val token = task.result
//                textView.text=token
                // Log and toast
                val msg = getString(R.string.token_prefix, token)
                Log.d(TAG, msg)
                Log.i("MyFirebaseService ", "Refreshed token :: $token")
                Toast.makeText(baseContext, msg, Toast.LENGTH_SHORT).show()

            })
        }

    }}