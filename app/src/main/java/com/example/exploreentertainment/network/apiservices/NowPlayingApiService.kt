package com.example.exploreentertainment.network.apiservices

import com.example.exploreentertainment.network.models.nowplaying.NPMovies
import com.example.exploreentertainment.network.models.NPShows
import com.example.exploreentertainment.network.models.TrendingMovies
import com.example.exploreentertainment.network.models.TrendingShows
import com.example.exploreentertainment.network.models.movies.RecentMovies
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
interface NowPlayingApiService {
    @GET("movie/now_playing")
    suspend fun getMovies(
            @Query("api_key") apiKey : String = "2e03601e7e59074d433b222a3db5b809")
            : NPMovies

    @GET("movie/now_playing")
    suspend fun getRecentMovies(
        @Query("api_key") apiKey : String = "2e03601e7e59074d433b222a3db5b809")
            : RecentMovies

    @GET("tv/on_the_air")
    suspend fun getShows(
        @Query("api_key") apiKey: String = "2e03601e7e59074d433b222a3db5b809"
    ): NPShows

    @GET("trending/movie/week")
    suspend fun getTrendingMovies(
        @Query("api_key") apiKey: String = "2e03601e7e59074d433b222a3db5b809"
    ): TrendingMovies

    @GET("trending/tv/week")
    suspend fun getTrendingShows(
        @Query("api_key") apiKey: String = "2e03601e7e59074d433b222a3db5b809"
    ): TrendingShows
}

/**
 * A public Api object that exposes the lazy-initialized Retrofit service
 */
object NowPlayingApi {
    val retrofitService : NowPlayingApiService by lazy { retrofit.create(
        NowPlayingApiService::class.java) }
}