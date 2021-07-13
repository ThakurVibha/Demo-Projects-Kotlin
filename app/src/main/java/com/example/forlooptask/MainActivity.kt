package com.example.forlooptask

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.AbsListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.paging.viewmore.RecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_meme.*
import java.lang.String
import java.util.*
import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {
    var currentItem = 0
    var totalItems: Int = 0
    var scrollOutItems: Int = 0
    var isScrolling = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        onClick()
//         adding on scroll change listener method for our nested scroll view.
        clLayout.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            recyclerview1.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                        isScrolling = true
                    }
                }

                override fun onScrolled(recyclerView1: RecyclerView, dx: Int, dy: Int) {
                    val layoutManager =
                        LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
                    currentItem = layoutManager.getChildCount()
                    totalItems = layoutManager.getItemCount()
                    scrollOutItems = layoutManager.findFirstVisibleItemPosition()
                    if (isScrolling && (currentItem + scrollOutItems == totalItems)) {
                        isScrolling = false
                    }
                }
            })
        }
    }

//    private fun onClick() {
//        paginateBtn.setOnClickListener {
//            val adapter = RecyclerViewAdapter(generateSimpleList())
//            val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
//            recyclerview1.layoutManager = layoutManager
//            recyclerview1.adapter = adapter
//            adapter.notifyDataSetChanged();
//
//        }
//    }
    private fun generateSimpleList(): List<RecyclerViewModel> {
        val recyclerViewModelList: MutableList<RecyclerViewModel> = ArrayList()
//        progress.setVisibility(View.VISIBLE);
        for (i in 1..10) {
            val model = RecyclerViewModel()
            model.numberItem = String.format(Locale.US, " %d", i)
            model.alphabet = String.format(Locale.US, "%d", i)
            recyclerViewModelList.add(model)
//                progress.setVisibility(View.GONE)
        }
        return recyclerViewModelList
    }

}

