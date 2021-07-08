package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.forlooptask.R
import kotlinx.android.synthetic.main.activity_first.*

class FirstActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
       onClick()
    }

    private fun onClick() {
        firstBtn.setOnClickListener {
            val intent=Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

    }
    
}