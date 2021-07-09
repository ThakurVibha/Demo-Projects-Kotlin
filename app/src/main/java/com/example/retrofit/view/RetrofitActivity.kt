package com.example.retrofit.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.forlooptask.R
import com.example.retrofit.viewmodel.RetrofitViewModel
import kotlinx.android.synthetic.main.activity_retrofit.*

class RetrofitActivity : AppCompatActivity() {
    lateinit var retrofitViewModel: RetrofitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)
        retrofitViewModel = ViewModelProvider(this).get(RetrofitViewModel::class.java)
        initApi()
        observeData()
        observeFailureData()
    }

    private fun observeFailureData() {
        retrofitViewModel.mOnFailureResponce().observe(this, Observer {
            Toast.makeText(this@RetrofitActivity, it.toString(), Toast.LENGTH_SHORT).show()
        })
    }

    private fun initApi() {
        refreshBtn.setOnClickListener {
            retrofitViewModel.fetchData()
        }
    }

    private fun observeData() {
        retrofitViewModel.mSuccessfulResponce().observe(this, Observer {
            tvType.text = it.type
            tvActivity.text = it.activity
            tvParticipents.text = it.participants

        })


    }

}







