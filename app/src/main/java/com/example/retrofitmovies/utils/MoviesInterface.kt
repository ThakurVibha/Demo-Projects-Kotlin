package com.example.retrofitmovies.utils

import com.example.retrofitmovies.model.MoviesModelItem
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface MoviesInterface {
//    A suspending function is simply a function that can be paused and resumed at a later time.
    @GET("films")
      fun getMoviesList(): Call<ArrayList<MoviesModelItem>>
}