package com.example.exploreentertainment.network.models

import com.squareup.moshi.Json

data class NPShows(
    @Json(name = "results")
    val npsResults: List<NowPlayingShow>
)

data class NowPlayingShow(
    @Json(name = "poster_path")
    val imgUrl2: String,
    @Json(name = "id")
    val id: Int
)