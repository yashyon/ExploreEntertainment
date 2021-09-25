package com.example.exploreentertainment.network.models.shows

import com.squareup.moshi.Json

data class PopularShows(
    @Json(name = "results")
    val results : List<PopularShow>
)

data class PopularShow(
    @Json(name = "poster_path")
    val imgUrl: String,
    @Json(name = "id")
    val id: Int
)