package com.example.exploreentertainment.ui.fragments.nowplaying

import androidx.lifecycle.*
import com.example.exploreentertainment.network.apiservices.MoviesShowsApi
import com.example.exploreentertainment.network.models.nowplaying.NowPlayingMovie
import com.example.exploreentertainment.network.models.NowPlayingShow
import com.example.exploreentertainment.network.models.trending.TrendingMovie
import com.example.exploreentertainment.network.models.TrendingShow
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
    private val _navigateToSelectedNPProperty = MutableLiveData<NowPlayingMovie?>()
    val navigateToSelectedNPProperty: MutableLiveData<NowPlayingMovie?>
        get() = _navigateToSelectedNPProperty

    private val _navigateToSelectedTProperty = MutableLiveData<TrendingMovie?>()
    val navigateToSelectedTProperty: MutableLiveData<TrendingMovie?>
        get() = _navigateToSelectedTProperty

    private val _navigateToSelectedNSProperty = MutableLiveData<NowPlayingShow?>()
    val navigateToSelectedNSProperty: MutableLiveData<NowPlayingShow?>
        get() = _navigateToSelectedNSProperty
    private val _navigateToSelectedTSProperty = MutableLiveData<TrendingShow?>()
    val navigateToSelectedTSProperty: MutableLiveData<TrendingShow?>
        get() = _navigateToSelectedTSProperty

    init{
        viewModelScope.launch {
            _nowPlayingMoviesList.value = MoviesShowsApi.retrofitService.getMovies().npResults
            _nowPlayingShowsList.value = MoviesShowsApi.retrofitService.getShows().npsResults
            _trendingMovies.value = MoviesShowsApi.retrofitService.getTrendingMovies().trendingMovies
            _trendingShows.value = MoviesShowsApi.retrofitService.getTrendingShows().trendingShows
        }
    }

    fun displayNPMoviePropertyDetails(nowPlayingMovie: NowPlayingMovie) {
        _navigateToSelectedNPProperty.value = nowPlayingMovie
    }
    fun displayNPMoviePropertyDetailsComplete(){
        _navigateToSelectedNPProperty.value = null
    }
    fun displayTrendingMoviePropertyDetails(trendingMovie: TrendingMovie) {
        _navigateToSelectedTProperty.value = trendingMovie
    }
    fun displayTrendingMoviePropertyDetailsComplete(){
        _navigateToSelectedTProperty.value = null
    }
    fun displayNPShowPropertyDetails(nowPlayingShow: NowPlayingShow) {
        _navigateToSelectedNSProperty.value = nowPlayingShow
    }
    fun displayNPShowPropertyDetailsComplete(){
        _navigateToSelectedNSProperty.value = null
    }
    fun displayTrendingShowPropertyDetails(trendingShow: TrendingShow) {
        _navigateToSelectedTSProperty.value = trendingShow
    }
    fun displayTrendingShowPropertyDetailsComplete(){
        _navigateToSelectedTSProperty.value = null
    }
}

//.retrofitService.getProperties().npResults
