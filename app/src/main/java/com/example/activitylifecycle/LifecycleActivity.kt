package com.example.activitylifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.forlooptask.R
import kotlinx.android.synthetic.main.activity_lifecycle.*

class LifecycleActivity : AppCompatActivity() {
    var TAG = "lifecycle"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)
        Log.d(TAG, "onCreate invoked");
        onClick()
    }

    private fun onClick() {
        destroyBtn.setOnClickListener {
            onDestroy()
        }
    }
//    * onStart() is just the layout in the foreground, but at this time the interface is invisible and can't be interacted with.
//    * onResume() At this time, you can see the interface, and people can operate it.
//    * The onPause() interface is also visible, but it can't be manipulated (partially visible is also visible)
//    * onStop() interface is not visible
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart invoked ")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume invoked")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart invoked ")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause invoked")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop invoked")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy invoked ")
    }

}