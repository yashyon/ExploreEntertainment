package com.example.exploreentertainment.network.models.movies

import com.squareup.moshi.Json


data class TopRatedMovies(
    @Json(name="results")
    val movies: List<TopRatedMovie>
)

data class TopRatedMovie(
    @Json(name="poster_path")
    val imgUrl : String
)