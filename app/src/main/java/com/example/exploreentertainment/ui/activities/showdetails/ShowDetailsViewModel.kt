package com.example.exploreentertainment.ui.activities.showdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exploreentertainment.network.apiservices.ShowDetailsApi
import com.example.exploreentertainment.network.models.shows.ShowDetails
import kotlinx.coroutines.launch

class ShowDetailsViewModel(id : Int) : ViewModel() {
    private val _showDetails = MutableLiveData<ShowDetails>()
    val showDetails : LiveData<ShowDetails>
        get() = _showDetails
    init {
        viewModelScope.launch {
            _showDetails.value = ShowDetailsApi.retrofitService.getShowDetails(id)
        }
    }
}