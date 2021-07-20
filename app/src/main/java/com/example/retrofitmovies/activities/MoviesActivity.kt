package com.example.retrofitmovies.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.forlooptask.R
import com.example.myfirstapp.mvvm.adapter.Imageadapter
import com.example.retrofitmovies.model.MoviesModelItem
import com.example.retrofitmovies.utils.MoviesInterface
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MoviesActivity : AppCompatActivity() {
    var page = 0
    var isLoading = false
    val limit = 10
    val TAG = "error"
    var BASE_URL = "https://ghibliapi.herokuapp.com/"
    var myAdapter: Imageadapter? = null
    var list = ArrayList<MoviesModelItem>()
    val layout = LinearLayoutManager(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        getMoviesData(page)
        initAdapter()

        moviesRecyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val visibleCount = layout.childCount
                val pastvisblecount = layout.findFirstCompletelyVisibleItemPosition()
                val total = myAdapter!!.itemCount
                if (!isLoading) {
                    if ((visibleCount + pastvisblecount) >= total) {
                        getMoviesData(page)
                        page++
                    }
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })
    }

    private fun initAdapter() {
        moviesRecyclerview.layoutManager = layout
        myAdapter = Imageadapter(list)
        Log.e(TAG, "onCreate: ")
        moviesRecyclerview.adapter = myAdapter
    }

    fun getMoviesData(page:Int) {
        isLoading = true
        progress_bar.visibility = View.VISIBLE
        Toast.makeText(this@MoviesActivity,"Wait....while we are loading data", Toast.LENGTH_LONG).show()
        val start = ((page) * limit) + 1
        val end = (page + 1) * limit
        val retrofit =
            Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()
        val moviesInterface: MoviesInterface = retrofit.create(MoviesInterface::class.java)
        val call = moviesInterface.getMoviesList()
        call.enqueue(object : Callback<ArrayList<MoviesModelItem>> {
            override fun onResponse(
                call: Call<ArrayList<MoviesModelItem>>,
                response: Response<ArrayList<MoviesModelItem>>
            ) {
                Handler(Looper.getMainLooper()).postDelayed({
                    if (response.isSuccessful) {
                        for(i in start..end){
                        response.body()?.let { data ->
                            myAdapter!!.mList = data
                            myAdapter!!.notifyDataSetChanged()
                        }
                    }}
                    isLoading = false
                    progress_bar.visibility = View.GONE
                }, 5000)
            }

            override fun onFailure(call: Call<ArrayList<MoviesModelItem>>, t: Throwable) {
                Log.e(TAG, t.localizedMessage)
            }
        })
    }
}