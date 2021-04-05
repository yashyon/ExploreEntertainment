package com.example.exploreentertainment.ui.fragments.nowplaying

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exploreentertainment.adapters.nowplayingAdapters.NowPlayingMoviesAdapter
import com.example.exploreentertainment.adapters.nowplayingAdapters.NowPlayingShowsAdapter
import com.example.exploreentertainment.adapters.trendingadapters.TrendingMoviesAdapter
import com.example.exploreentertainment.adapters.trendingadapters.TrendingShowsAdapter
import com.example.exploreentertainment.databinding.NowPlayingFragmentBinding

class NowPlayingFragment : Fragment() {

    private val viewModel : NowPlayingViewModel by lazy{
        ViewModelProvider(requireActivity()).get(NowPlayingViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = NowPlayingFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = requireActivity()
        binding.viewModel = viewModel
        binding.recyclerView.adapter = NowPlayingMoviesAdapter()
        binding.recyclerView2.adapter = NowPlayingShowsAdapter()
        binding.trendingMoviesRv.adapter = TrendingMoviesAdapter()
        binding.trendingShowsRv.adapter = TrendingShowsAdapter()
        return binding.root
    }
}