package com.example.retrofitmovies.activities

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.forlooptask.R
import com.example.myfirstapp.mvvm.adapter.Imageadapter
import com.example.retrofitmovies.model.MoviesModelItem
import com.example.retrofitmovies.utils.MoviesInterface
import kotlinx.android.synthetic.main.activity_movies.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MoviesActivity : AppCompatActivity() {
    val TAG = "error"
    var BASE_URL = "https://ghibliapi.herokuapp.com/"
    var myAdapter: Imageadapter? = null
    var list = ArrayList<MoviesModelItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
       initAdapter()
        getMoviesData()
    }

    private fun initAdapter() {
        val layout = LinearLayoutManager(this)
        moviesRecyclerview.layoutManager=layout
        myAdapter = Imageadapter(list)
        Log.e(TAG, "onCreate: " )
        moviesRecyclerview.adapter = myAdapter
    }
    fun getMoviesData() {
        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        val moviesInterface: MoviesInterface = retrofit.create(MoviesInterface::class.java)
        val call = moviesInterface.getMoviesList()
        call.enqueue(object : Callback<ArrayList<MoviesModelItem>> {
            override fun onResponse(call: Call<ArrayList<MoviesModelItem>>, response: Response<ArrayList<MoviesModelItem>>) {
                if (response.isSuccessful) {
                        response.body()?.let { data ->
                            myAdapter!!.mList = data
                            myAdapter!!.notifyDataSetChanged()
                        }
                }}
            override fun onFailure(call: Call<ArrayList<MoviesModelItem>>, t: Throwable) {
                Log.e(TAG, t.localizedMessage)
            }
        })
    }
}