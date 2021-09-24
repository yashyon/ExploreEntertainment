package com.example.exploreentertainment.network.models.shows

import com.google.gson.annotations.SerializedName

data class SearchShows(
    @SerializedName("results")
    val list : ArrayList<SearchShow>
)

data class SearchShow(
    @SerializedName( "original_name")
    val name: String
)