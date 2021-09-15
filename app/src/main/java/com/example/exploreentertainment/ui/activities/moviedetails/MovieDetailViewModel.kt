package com.example.exploreentertainment.ui.activities.moviedetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exploreentertainment.network.apiservices.MoviesDetailsApi
import com.example.exploreentertainment.network.apiservices.MoviesShowsApi
import com.example.exploreentertainment.network.models.movies.MovieDetails
import kotlinx.coroutines.launch

class MovieDetailViewModel(id : Int) : ViewModel(){

    private val _movieDetails = MutableLiveData<MovieDetails>()
    val movieDetails : LiveData<MovieDetails>
        get() = _movieDetails
    init {
        viewModelScope.launch {
            _movieDetails.value = MoviesDetailsApi.retrofitService.getMovieDetails(id)
        }
    }
}