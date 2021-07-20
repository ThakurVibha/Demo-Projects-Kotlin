package com.example.endlessrecyclerview
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forlooptask.R
import com.example.paging.NumberAdapter
import kotlinx.android.synthetic.main.activity_main.*
class MyPagingActivity : AppCompatActivity() {

    val numberList: MutableList<String> = ArrayList()
    var page = 0
    var isLoading = false
    val limit = 10
    lateinit var adapter: NumberAdapter
    lateinit var layoutManager: LinearLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        getPage()

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {

//                if (dy > 0) {
                    val visibleItemCount = layoutManager.childCount
                    val pastVisibleItem = layoutManager.findFirstCompletelyVisibleItemPosition()
                    val total = adapter.itemCount

                    if (!isLoading) {
                        if ((visibleItemCount + pastVisibleItem) >= total) {
                            page++
                            getPage()
                        }
                    }
//                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }
    fun getPage() {
        isLoading = true
        progressBar.visibility = View.VISIBLE
        val start = ((page) * limit) + 1
        val end = (page + 1) * limit
        for (i in start..end) {
            numberList.add( i.toString())
        }
        Handler().postDelayed({
            if (::adapter.isInitialized) {
                adapter.notifyDataSetChanged()
            } else {
                adapter = NumberAdapter(this)
                recyclerView.adapter = adapter
            }
            isLoading = false
            progressBar.visibility = View.GONE
        }, 5000)
    }
}
