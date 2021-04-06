package com.example.exploreentertainment.network.models.movies

import com.squareup.moshi.Json

data class UpComingMovies(
    @Json(name = "results")
    val movies : List<UpComingMovie>
)

data class UpComingMovie(
    @Json(name = "poster_path")
    val imgUrl : String
)