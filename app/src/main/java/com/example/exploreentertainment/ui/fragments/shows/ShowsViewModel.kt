package com.example.exploreentertainment.ui.fragments.shows

import android.graphics.Movie
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exploreentertainment.network.apiservices.MoviesShowsApi
import com.example.exploreentertainment.network.apiservices.MoviesShowsApiService
import com.example.exploreentertainment.network.models.NowPlayingShow
import com.example.exploreentertainment.network.models.movies.RecentMovie
import com.example.exploreentertainment.network.models.shows.PopularShow
import com.example.exploreentertainment.network.models.shows.SearchShow
import com.example.exploreentertainment.network.repositories.SearchMoviesRepository
import kotlinx.coroutines.launch

class ShowsViewModel : ViewModel() {
    private val _searchShows = MutableLiveData<ArrayList<SearchShow>>()
    val searchShows: LiveData<ArrayList<SearchShow>>
        get() = _searchShows

    private val _recentShowsList = MutableLiveData<List<NowPlayingShow>>()
    val recentShowsList: LiveData<List<NowPlayingShow>>
        get() = _recentShowsList
    private val _navigateToSelectedNSProperty = MutableLiveData<NowPlayingShow?>()
    val navigateToSelectedNSProperty: MutableLiveData<NowPlayingShow?>
        get() = _navigateToSelectedNSProperty

    fun displayNPShowPropertyDetails(nowPlayingShow: NowPlayingShow) {
        _navigateToSelectedNSProperty.value = nowPlayingShow
    }
    fun displayNPShowPropertyDetailsComplete(){
        _navigateToSelectedNSProperty.value = null
    }
    private val _popularShowsList = MutableLiveData<List<PopularShow>>()
    val popularShowsList: LiveData<List<PopularShow>>
        get() = _popularShowsList
    private val _navigateToSelectedPSProperty = MutableLiveData<PopularShow?>()
    val navigateToSelectedPSProperty: MutableLiveData<PopularShow?>
        get() = _navigateToSelectedPSProperty

    fun displayPopularShowsPropertyDetails(popularShow: PopularShow) {
        _navigateToSelectedPSProperty.value = popularShow
    }
    fun displayPopularShowsPropertyDetailsComplete(){
        _navigateToSelectedPSProperty.value = null
    }
    init {
        viewModelScope.launch {
            _recentShowsList.value = MoviesShowsApi.retrofitService.getShows().npsResults
            _popularShowsList.value = MoviesShowsApi.retrofitService.getPopularShows().results
        }
    }
    fun fetchSearch(search: String) {
        viewModelScope.launch {
            _searchShows.value = SearchMoviesRepository.searchedShows(searchText = search)
        }
    }
}