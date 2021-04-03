package com.example.exploreentertainment.network.models.nowplaying

import com.squareup.moshi.Json

/*Now Playing Movies*/

data class NPMovies(
    @Json(name = "results")
    val npResults : List<NowPlayingMovie>
)
data class NowPlayingMovie (
    @Json(name = "poster_path")
    val imgUrl: String
)