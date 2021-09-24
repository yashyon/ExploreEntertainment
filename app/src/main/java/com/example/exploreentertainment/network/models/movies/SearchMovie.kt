package com.example.exploreentertainment.network.models.movies

import com.google.gson.annotations.SerializedName

data class SearchMovies(
    @SerializedName("results")
    val list : ArrayList<SearchMovie>
)

data class SearchMovie(
    @SerializedName( "original_title")
    val name: String
)