package com.example.exploreentertainment.ui.fragments.movies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exploreentertainment.R
import com.example.exploreentertainment.adapters.moviesadapters.RecentMoviesAdapter
import com.example.exploreentertainment.databinding.MoviesFragmentBinding
import com.example.exploreentertainment.databinding.NowPlayingFragmentBinding
import com.example.exploreentertainment.ui.fragments.nowplaying.NowPlayingViewModel

class MoviesFragment : Fragment() {

    private val viewModel: MoviesViewModel by lazy {
        ViewModelProvider(requireActivity()).get(MoviesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = MoviesFragmentBinding.inflate(inflater)
        binding.recentMoviesRv.adapter = RecentMoviesAdapter()
        binding.viewModel = viewModel
        return binding.root
    }


}