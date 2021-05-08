package com.example.exploreentertainment.ui.fragments.nowplaying

import androidx.lifecycle.*
import com.example.exploreentertainment.network.apiservices.NowPlayingApi
import com.example.exploreentertainment.network.models.nowplaying.NowPlayingMovie
import com.example.exploreentertainment.network.models.NowPlayingShow
import com.example.exploreentertainment.network.models.TrendingMovie
import com.example.exploreentertainment.network.models.TrendingShow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NowPlayingViewModel : ViewModel() {

    private val _nowPlayingMoviesList = MutableLiveData<List<NowPlayingMovie>>()
    val nowPlayingMoviesList : LiveData<List<NowPlayingMovie>>
    get() = _nowPlayingMoviesList

    private val _nowPlayingShowsList = MutableLiveData<List<NowPlayingShow>>()
    val nowPlayingShowsList : LiveData<List<NowPlayingShow>>
        get() = _nowPlayingShowsList

    private val _trendingShows = MutableLiveData<List<TrendingShow>>()
    val trendingShows : LiveData<List<TrendingShow>>
    get() = _trendingShows

    private val _trendingMovies = MutableLiveData<List<TrendingMovie>>()
    val trendingMovies : LiveData<List<TrendingMovie>>
        get() = _trendingMovies

    /*For Navigation of a particular on click*/
    private val _navigateToSelectedProperty = MutableLiveData<NowPlayingMovie>()
    val navigateToSelectedProperty: LiveData<NowPlayingMovie>
        get() = _navigateToSelectedProperty

    init{
        viewModelScope.launch {
            _nowPlayingMoviesList.value = NowPlayingApi.retrofitService.getMovies().npResults
            _nowPlayingShowsList.value = NowPlayingApi.retrofitService.getShows().npsResults
            _trendingMovies.value = NowPlayingApi.retrofitService.getTrendingMovies().trendingMovies
            _trendingShows.value = NowPlayingApi.retrofitService.getTrendingShows().trendingShows
        }
    }

    fun displayPropertyDetails(nowPlayingMovie: NowPlayingMovie) {
        _navigateToSelectedProperty.value = nowPlayingMovie
    }
}

//.retrofitService.getProperties().npResults
