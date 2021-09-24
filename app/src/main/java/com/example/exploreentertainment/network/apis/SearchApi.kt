package com.example.exploreentertainment.network.apis

import com.example.exploreentertainment.network.models.movies.SearchMovies
import com.example.exploreentertainment.network.models.shows.SearchShows
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface SearchApi {

    @GET("search/movie")
    fun getSearchedMovies(
        @Query("api_key") apiKey: String = "2e03601e7e59074d433b222a3db5b809",
        @Query("query") querySearch: String
    ): Call<SearchMovies>

    @GET("search/tv")
    fun getSearchedShows(
        @Query("api_key") apiKey: String = "2e03601e7e59074d433b222a3db5b809",
        @Query("query") querySearch: String
    ) : Call<SearchShows>
}