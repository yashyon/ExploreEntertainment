package com.example.exploreentertainment.network.models.movies

import com.example.exploreentertainment.network.models.NowPlayingMovie
import com.squareup.moshi.Json

data class RecentMovies(
    @Json(name = "results")
    val recentMovies : List<RecentMovie>
)
data class RecentMovie(
    @Json(name = "poster_path")
    val imgUrl: String
)