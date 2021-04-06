package com.example.exploreentertainment.ui.fragments.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exploreentertainment.network.apiservices.NowPlayingApi
import com.example.exploreentertainment.network.models.movies.*
import com.example.exploreentertainment.network.repositories.SearchMoviesRepository
import kotlinx.coroutines.launch

class MoviesViewModel : ViewModel() {
    private val _recentMoviesList = MutableLiveData<List<RecentMovie>>()
    val recentMoviesList : LiveData<List<RecentMovie>>
        get() = _recentMoviesList

    private val _searchMovies = MutableLiveData<ArrayList<SearchMovie>>()
    val searchMovies : LiveData<ArrayList<SearchMovie>>
        get() = _searchMovies

    private val _popularMoviesList = MutableLiveData<List<PopularMovie>>()
    val popularMoviesList : LiveData<List<PopularMovie>>
        get() = _popularMoviesList

    private val _topRatedMoviesList = MutableLiveData<List<TopRatedMovie>>()
    val topRatedMoviesList : LiveData<List<TopRatedMovie>>
        get() = _topRatedMoviesList

    private val _upComingMoviesList = MutableLiveData<List<UpComingMovie>>()
    val upComingMoviesList : LiveData<List<UpComingMovie>>
        get() = _upComingMoviesList

    init{
        viewModelScope.launch{
            _recentMoviesList.value = NowPlayingApi.retrofitService.getRecentMovies().recentMovies
            _popularMoviesList.value = NowPlayingApi.retrofitService.getPopularMovies().results
            _topRatedMoviesList.value = NowPlayingApi.retrofitService.getTopRatedMovies().movies
            _upComingMoviesList.value = NowPlayingApi.retrofitService.getUpComingMovies().movies
        }
    }

    fun fetchSearch(search : String){
            viewModelScope.launch {
                _searchMovies.value  = SearchMoviesRepository.searchedMovies(searchText = search)
            }
    }
}













