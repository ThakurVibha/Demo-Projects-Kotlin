package com.example.retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forlooptask.R
import com.example.retrofit.adapters.CoinDeskAdapter
import com.example.retrofit.viewmodel.CoinDeskViewModel
import kotlinx.android.synthetic.main.activity_coin_desk.*

class CoinDeskActivity : AppCompatActivity() {
    lateinit var coinDeskViewModel: CoinDeskViewModel
    lateinit var adapter: CoinDeskAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_desk)
        coinDeskViewModel = ViewModelProvider(this).get(CoinDeskViewModel::class.java)
        initAdapter()
        initApi()
        observeResponse()
    }

    private fun observeResponse() {
        coinDeskViewModel.mSuccessfulResponce().observe(this, Observer {
            var uaa = it
//            adapter.update(it.bpi)
        })
        coinDeskViewModel.mOnFailureResponse().observe(this, Observer {

            Toast.makeText(this@CoinDeskActivity, it.toString(), Toast.LENGTH_SHORT).show()
            Toast.makeText(this@CoinDeskActivity, "unable to fetch data", Toast.LENGTH_SHORT).show()

        })
    }


    private fun initApi() {
        coinDeskViewModel.fetchData()
    }

    private fun initAdapter() {
        val layoutManager = LinearLayoutManager(this)
        recyclerview.layoutManager = layoutManager
        adapter = CoinDeskAdapter(this)
        recyclerview.adapter = adapter
    }
}