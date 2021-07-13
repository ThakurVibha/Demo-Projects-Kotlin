package com.example.retrofit.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forlooptask.R
import com.example.retrofit.adapters.CoinDeskAdapter
import com.example.retrofit.model.CoinModel
//import com.example.retrofit.viewmodel.CoinDeskViewModel
import kotlinx.android.synthetic.main.activity_coin_desk.*
import kotlinx.android.synthetic.main.activity_image_picker.*
import kotlinx.android.synthetic.main.coin_desk_item.*

//class CoinDeskActivity : AppCompatActivity() {
//    lateinit var coinDeskViewModel: CoinDeskViewModel
//    private lateinit var adapter: CoinDeskAdapter
//    var list = ArrayList<CoinModel>()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.coin_desk_item)
//        coinDeskViewModel = ViewModelProvider(this).get(CoinDeskViewModel::class.java)
////        initAdapter()
//        initApi()
//        observeResponse()
//    }
//    private fun observeResponse() {
//        coinDeskViewModel.mSuccessfulResponce().observe(this, Observer {
////            code.text = it.bpi.EUR.code
////            rate.text = it.bpi.EUR.rate
////            description.text = it.disclaimer
////            time.text = it.time.toString()
////            adapter.update(it)
//        })
//        coinDeskViewModel.mOnFailureResponse().observe(this, Observer {
//
//            Toast.makeText(this@CoinDeskActivity, it.toString(), Toast.LENGTH_SHORT).show()
//            Toast.makeText(this@CoinDeskActivity, "unable to fetch data", Toast.LENGTH_SHORT).show()
//        })
//    }
//
//    private fun initApi() {
//        coinDeskViewModel.fetchData()
////        coinDeskViewModel.fetchPostRequest()
////        coinDeskViewModel.getSpecificPost(32)
////        coinDeskViewModel.deletePost(8)
////        coinDeskViewModel.postData(postEdit.getText().toString());
//
//    }
//
////    private fun initAdapter() {
////        val layoutManager = LinearLayoutManager(this)
////        recyclerview.layoutManager = layoutManager
////        adapter = CoinDeskAdapter(this)
////        recyclerview.adapter = adapter
////    }
//}