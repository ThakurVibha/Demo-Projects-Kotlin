package com.example.retrofitmovies.model

import com.google.gson.annotations.SerializedName

data class MoviesModelItem(
    @SerializedName("description")
    val description: String,
    @SerializedName("director")
    val director: String,
    val id: String,
    val locations: List<String>,
    val original_title: String,
    @SerializedName("original_title_romanised")
    val original_title_romanised: String,
    val people: List<String>,
    @SerializedName("producer")
    val producer: String,
    @SerializedName("release_date")
    val release_date: String,
    val rt_score: String,
    val running_time: String,
    val species: List<String>,
    @SerializedName("title")
    val title: String,
    val url: String,
    val vehicles: List<String>,
    val items: List<MoviesModelItem>? = null

)