package com.example.exploreentertainment.ui.fragments.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exploreentertainment.network.apiservices.NowPlayingApi
import com.example.exploreentertainment.network.models.movies.RecentMovie
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
    private val _recentMoviesList = MutableLiveData<List<RecentMovie>>()
    val recentMoviesList : LiveData<List<RecentMovie>>
        get() = _recentMoviesList

    init{
        viewModelScope.launch {
            _recentMoviesList.value = NowPlayingApi.retrofitService.getRecentMovies().recentMovies
        }
    }
}