package com.example.exploreentertainment.network.repositories

import android.util.Log
import com.example.exploreentertainment.network.apis.SearchApi
import com.example.exploreentertainment.network.models.movies.SearchMovie
import com.example.exploreentertainment.network.models.movies.SearchMovies
import com.example.exploreentertainment.network.models.shows.SearchShow
import com.example.exploreentertainment.network.models.shows.SearchShows
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SearchMoviesRepository {
    private val api: SearchApi
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(SearchApi::class.java)
    }
    var listM = ArrayList<SearchMovie>()
    var listS = ArrayList<SearchShow>()

    suspend fun searchedMovies(searchText : String) : ArrayList<SearchMovie>{
        val responseBody : Response<SearchMovies>
        api.getSearchedMovies(querySearch = searchText).enqueue(object : Callback<SearchMovies> {
            override fun onResponse(call: Call<SearchMovies>, response: Response<SearchMovies>) {
                if(response.isSuccessful) {
                    listM = response.body()!!.list
                    Log.d("Repository", "Movies: ${listM[0].name}")
                }else {
                        Log.d("Repository", "Failed to get response")
                    }
            }
            override fun onFailure(call: Call<SearchMovies>, t: Throwable) {
                Log.e("Repository", "onFailure", t)
            }
        })
        return listM
    }
    suspend fun searchedShows(searchText : String) : ArrayList<SearchShow>{
        val responseBody : Response<SearchShows>
        api.getSearchedShows(querySearch = searchText).enqueue(object : Callback<SearchShows> {
            override fun onResponse(call: Call<SearchShows>, response: Response<SearchShows>) {
                if(response.isSuccessful) {
                    listS = response.body()!!.list
                    Log.d("Repository", "Shows: ${listS[0].name}")
                }else {
                    Log.d("Repository", "Failed to get response")
                }
            }
            override fun onFailure(call: Call<SearchShows>, t: Throwable) {
                Log.e("Repository", "onFailure", t)
            }
        })
        return listS
    }
}