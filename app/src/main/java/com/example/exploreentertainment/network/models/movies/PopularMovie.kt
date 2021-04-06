package com.example.exploreentertainment.network.models.movies

import com.squareup.moshi.Json


data class PopularMovies(
    @Json(name = "results")
    val results : List<PopularMovie>
)

data class PopularMovie(
    @Json(name = "poster_path")
    val imgUrl : String
)