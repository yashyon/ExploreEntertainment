package com.example.exploreentertainment.ui.activities.showdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ShowDetailsViewModelFactory(private val id : Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShowDetailsViewModel::class.java)) {
            return ShowDetailsViewModel(id) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}