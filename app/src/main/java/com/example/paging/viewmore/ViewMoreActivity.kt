package com.example.paging.viewmore

import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.AbsListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forlooptask.R
import com.example.forlooptask.RecyclerViewModel
import kotlinx.android.synthetic.main.activity_view_more.*
import java.lang.String
import java.util.*
import kotlin.collections.ArrayList


class ViewMoreActivity : AppCompatActivity() {
    var currentItem = 0
    var totalItems: Int = 0
    var scrollOutItems: Int = 0
    var isScrolling = false
    lateinit var adapter: RecyclerViewAdapter
    lateinit var list: ArrayList<kotlin.String>
    override fun onCreate(savedInstanceState: Bundle?) {
        val a = arrayOf(
            "25",
            "91",
            "65",
            "4",
            "60",
            "67",
            "56",
            "1",
            "80",
            "38",
            "29",
            "97",
            "11",
            "71",
            "59"
        )
        var list = ArrayList(Arrays.asList(a));
        var adapter = RecyclerViewAdapter(list, this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_more)
        var manager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        myrecycler.setAdapter(adapter)
        myrecycler.setLayoutManager(manager)
        myrecycler.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL) {
                    isScrolling = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                currentItem = manager.getChildCount()
                totalItems = manager.getItemCount()
                scrollOutItems = manager.findFirstVisibleItemPosition()
                if (isScrolling && currentItem + scrollOutItems === totalItems) {
                    isScrolling = false
                    fetchData()
                }
            }
        })
    }
    private fun fetchData() {
        myprogress.setVisibility(View.VISIBLE);
        Handler().postDelayed(Runnable() {

            for (i in 1..10) {
                list.add(Math.floor(Math.random() * 100).toString())
                adapter.notifyDataSetChanged();
                myprogress.setVisibility(View.GONE);

            }
        }, 5000);
    }
}

