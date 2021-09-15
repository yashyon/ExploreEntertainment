package com.example.exploreentertainment.network.apiservices

import com.example.exploreentertainment.network.models.movies.MovieDetails
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/"
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()
/*https://api.themoviedb.org/3/movie/566525?api_key=2e03601e7e59074d433b222a3db5b809*/
interface MovieDetailsApiService {
    @GET("movie/{id}?api_key=2e03601e7e59074d433b222a3db5b809")
    suspend fun getMovieDetails(
        @Path("id") id : Int
    ) : MovieDetails
}
object MoviesDetailsApi {
    val retrofitService: MovieDetailsApiService by lazy {
        retrofit.create(
            MovieDetailsApiService ::class.java
        )
    }
}