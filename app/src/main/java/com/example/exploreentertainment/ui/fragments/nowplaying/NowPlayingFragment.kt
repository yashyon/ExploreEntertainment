package com.example.exploreentertainment.ui.fragments.nowplaying

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.exploreentertainment.adapters.nowplayingAdapters.NowPlayingMoviesAdapter
import com.example.exploreentertainment.adapters.nowplayingAdapters.NowPlayingShowsAdapter
import com.example.exploreentertainment.adapters.trendingadapters.TrendingMoviesAdapter
import com.example.exploreentertainment.adapters.trendingadapters.TrendingShowsAdapter
import com.example.exploreentertainment.databinding.NowPlayingFragmentBinding
import com.example.exploreentertainment.ui.activities.moviedetails.MovieDetail

class NowPlayingFragment : Fragment() {

    private val viewModel : NowPlayingViewModel by lazy{
        ViewModelProvider(requireActivity()).get(NowPlayingViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NowPlayingFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = requireActivity()
        binding.viewModel = viewModel
//        binding.recyclerView.adapter = NowPlayingMoviesAdapter(requireActivity())
        binding.nowPlayingMoviesRecyclerView.adapter = NowPlayingMoviesAdapter(NowPlayingMoviesAdapter.OnClickListener{
            viewModel.displayPropertyDetails(it)
        })

        viewModel.navigateToSelectedProperty.observe(viewLifecycleOwner, Observer{
            if(null != it){
                val npMovieIntent = Intent(requireContext(), MovieDetail::class.java)
                val movieId = it.id
                startActivity(npMovieIntent)
                viewModel.displayNPMoviePropertyDetailsComplete()
            }
        })
        binding.nowPlayingShowsRecyclerView.adapter = NowPlayingShowsAdapter()
        binding.trendingMoviesRv.adapter = TrendingMoviesAdapter()
        binding.trendingShowsRv.adapter = TrendingShowsAdapter()
        return binding.root
    }

}