package com.example.retrofitmovies.utils

import com.example.retrofitmovies.model.MoviesModelItem
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface MoviesInterface {

    @GET("films")
    fun getMoviesList(): Call<ArrayList<MoviesModelItem>>
}