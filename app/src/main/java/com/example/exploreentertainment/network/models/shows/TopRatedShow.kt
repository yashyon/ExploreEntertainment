package com.example.exploreentertainment.network.models.shows

import com.squareup.moshi.Json

data class TopRatedShows(
    @Json(name = "results")
    val results : List<TopRatedShow>
)

data class TopRatedShow(
    @Json(name = "poster_path")
    val imgUrl: String,
    @Json(name = "id")
    val id: Int
)