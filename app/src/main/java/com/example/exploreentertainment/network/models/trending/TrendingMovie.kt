package com.example.exploreentertainment.network.models.trending

import com.squareup.moshi.Json

data class TrendingMovies(
    @Json(name = "results")
    val trendingMovies: List<TrendingMovie>
)

data class TrendingMovie(
    @Json(name = "backdrop_path")
    val imgUrl : String,
    @Json(name = "original_title")
    val title : String,
    @Json(name = "id")
    val id : Int
)