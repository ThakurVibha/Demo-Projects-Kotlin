package com.example.forlooptask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.String
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    var TAG = "//"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setAdapter()
    }

    private fun setAdapter() {
        val adapter = RecyclerViewAdapter(generateSimpleList())
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerview1.layoutManager = layoutManager
        recyclerview1.adapter = adapter      }

    private fun generateSimpleList(): List<RecyclerViewModel> {
        val recyclerViewModelList: MutableList<RecyclerViewModel> = ArrayList()
        for (i in 1..100) {
            if(i%2==0){
                val model = RecyclerViewModel()
                model.numberItem = String.format(Locale.US, " %d", i)
                model.alphabet=String.format(Locale.US, "%d", i)
                recyclerViewModelList.add(model)
            }
        }
        return recyclerViewModelList
    }


}