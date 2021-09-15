package com.example.exploreentertainment.network.apiservices

import com.example.exploreentertainment.network.models.nowplaying.NPMovies
import com.example.exploreentertainment.network.models.NPShows
import com.example.exploreentertainment.network.models.TrendingMovies
import com.example.exploreentertainment.network.models.TrendingShows
import com.example.exploreentertainment.network.models.movies.*
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"
private const val apikey = "2e03601e7e59074d433b222a3db5b809"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface MoviesShowsApiService {
    @GET("movie/now_playing")
    suspend fun getMovies(
        @Query("api_key") apiKey: String = apikey
    ): NPMovies

    @GET("movie/now_playing")
    suspend fun getRecentMovies(
        @Query("api_key") apiKey: String = apikey
    ): RecentMovies

    @GET("tv/on_the_air")
    suspend fun getShows(
        @Query("api_key") apiKey: String = apikey
    ): NPShows

    @GET("trending/movie/week")
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String = apikey
    ): TrendingMovies

    @GET("trending/tv/week")
    suspend fun getTrendingShows(
        @Query("api_key") apiKey: String = apikey
    ): TrendingShows

    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("api_key") apiKey: String = apikey
    ): PopularMovies

    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(
        @Query("api_key") apiKey: String = apikey
    ): TopRatedMovies

    @GET("movie/upcoming")
    suspend fun getUpComingMovies(
        @Query("api_key") apiKey: String = apikey
    ): UpComingMovies

}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object MoviesShowsApi {
    val retrofitService: MoviesShowsApiService by lazy {
        retrofit.create(
            MoviesShowsApiService::class.java
        )
    }
}