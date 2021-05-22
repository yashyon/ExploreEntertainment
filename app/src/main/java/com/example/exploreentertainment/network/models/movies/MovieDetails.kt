package com.example.exploreentertainment.network.models.movies

import com.squareup.moshi.Json

data class MovieDetails(
    @Json(name="backdrop_path")
    val imgUrl : String,
    @Json(name="title")
    val title : String,
    @Json(name="overview")
    val overview : String,
    @Json(name = "vote_average")
    val ratingText : String,
    @Json(name="release_date")
    val releasedDate : String
)

/*
*  image
* Title movie
* rating text
* overview
* released date
*
*
*
*/