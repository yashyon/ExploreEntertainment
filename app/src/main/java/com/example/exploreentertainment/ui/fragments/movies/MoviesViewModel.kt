package com.example.exploreentertainment.ui.fragments.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exploreentertainment.network.apiservices.MoviesShowsApi
import com.example.exploreentertainment.network.models.movies.*
import com.example.exploreentertainment.network.repositories.SearchMoviesRepository
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {

    /*Search Bar Results*/
    private val _searchMovies = MutableLiveData<ArrayList<SearchMovie>>()
    val searchMovies: LiveData<ArrayList<SearchMovie>>
        get() = _searchMovies

    /*Lists of recycler views in fragment*/
    private val _recentMoviesList = MutableLiveData<List<RecentMovie>>()
    val recentMoviesList: LiveData<List<RecentMovie>>
        get() = _recentMoviesList

    private val _popularMoviesList = MutableLiveData<List<PopularMovie>>()
    val popularMoviesList: LiveData<List<PopularMovie>>
        get() = _popularMoviesList

    private val _topRatedMoviesList = MutableLiveData<List<TopRatedMovie>>()
    val topRatedMoviesList: LiveData<List<TopRatedMovie>>
        get() = _topRatedMoviesList

    private val _upComingMoviesList = MutableLiveData<List<UpComingMovie>>()
    val upComingMoviesList: LiveData<List<UpComingMovie>>
        get() = _upComingMoviesList

    init {
        viewModelScope.launch {
            _recentMoviesList.value = MoviesShowsApi.retrofitService.getRecentMovies().recentMovies
            _popularMoviesList.value = MoviesShowsApi.retrofitService.getPopularMovies().results
            _topRatedMoviesList.value = MoviesShowsApi.retrofitService.getTopRatedMovies().movies
            _upComingMoviesList.value = MoviesShowsApi.retrofitService.getUpComingMovies().movies
        }
    }

    fun fetchSearch(search: String) {
        viewModelScope.launch {
            _searchMovies.value = SearchMoviesRepository.searchedMovies(searchText = search)
        }
    }
}













