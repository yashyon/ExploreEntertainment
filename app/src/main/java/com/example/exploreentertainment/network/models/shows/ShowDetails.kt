package com.example.exploreentertainment.network.models.shows

import com.squareup.moshi.Json

data class ShowDetails(
    @Json(name="backdrop_path")
    val imgUrl : String,
    @Json(name="original_name")
    val title : String,
    @Json(name="overview")
    val overview : String,
    @Json(name = "vote_average")
    val ratingText : String,
    @Json(name="first_air_date")
    val releasedDate : String
)