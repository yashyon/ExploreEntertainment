package com.example.exploreentertainment.ui.fragments.shows

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exploreentertainment.network.models.shows.SearchShow
import com.example.exploreentertainment.network.repositories.SearchMoviesRepository
import kotlinx.coroutines.launch

class ShowsViewModel : ViewModel() {
    private val _searchShows = MutableLiveData<ArrayList<SearchShow>>()
    val searchShows: LiveData<ArrayList<SearchShow>>
        get() = _searchShows

    fun fetchSearch(search: String) {
        viewModelScope.launch {
            _searchShows.value = SearchMoviesRepository.searchedShows(searchText = search)
        }
    }
}