package com.example.exploreentertainment.network.models

import com.squareup.moshi.Json

data class TrendingShows(
    @Json(name = "results")
    val trendingShows: List<TrendingShow>
)

data class TrendingShow(
    @Json(name = "backdrop_path")
    val imgUrl : String,
    @Json(name = "original_name")
    val title : String,
    @Json(name = "id")
    val id : Int
)