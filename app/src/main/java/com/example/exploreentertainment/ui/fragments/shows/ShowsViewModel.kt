package com.example.exploreentertainment.ui.fragments.shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exploreentertainment.network.apiservices.MoviesShowsApi
import com.example.exploreentertainment.network.apiservices.MoviesShowsApiService
import com.example.exploreentertainment.network.models.NowPlayingShow
import com.example.exploreentertainment.network.models.movies.RecentMovie
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
    init {
        viewModelScope.launch {
            _recentShowsList.value = MoviesShowsApi.retrofitService.getShows().npsResults

        }
    }
    fun fetchSearch(search: String) {
        viewModelScope.launch {
            _searchShows.value = SearchMoviesRepository.searchedShows(searchText = search)
        }
    }
}