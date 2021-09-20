package com.example.exploreentertainment.ui.fragments.nowplaying

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.exploreentertainment.adapters.nowplayingAdapters.NowPlayingMoviesAdapter
import com.example.exploreentertainment.adapters.nowplayingAdapters.NowPlayingShowsAdapter
import com.example.exploreentertainment.adapters.trendingadapters.TrendingMoviesAdapter
import com.example.exploreentertainment.adapters.trendingadapters.TrendingShowsAdapter
import com.example.exploreentertainment.databinding.NowPlayingFragmentBinding
import com.example.exploreentertainment.ui.activities.moviedetails.MovieDetail
import com.example.exploreentertainment.ui.activities.showdetails.ShowDetail

class NowPlayingFragment : Fragment() {

    private val viewModel: NowPlayingViewModel by lazy {
        ViewModelProvider(requireActivity()).get(NowPlayingViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = NowPlayingFragmentBinding.inflate(inflater)
        binding.lifecycleOwner = requireActivity()
        binding.viewModel = viewModel
        /*Now Playing Movies Recycler View Adapter*/
        binding.nowPlayingMoviesRecyclerView.adapter =
            NowPlayingMoviesAdapter(NowPlayingMoviesAdapter.OnClickListener {
                viewModel.displayNPMoviePropertyDetails(it)
            })
        viewModel.navigateToSelectedNPProperty.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                val npMovieIntent = Intent(requireContext(), MovieDetail::class.java)
                val movieId = it.id
                npMovieIntent.putExtra(MovieDetail.movie_id, movieId);
                startActivity(npMovieIntent)
                viewModel.displayNPMoviePropertyDetailsComplete()
            }
        })
        /*Trending Movies Recycler View Adapter*/
        binding.trendingMoviesRv.adapter =
            TrendingMoviesAdapter(TrendingMoviesAdapter.OnClickListener {
                viewModel.displayTrendingMoviePropertyDetails(it)
            })
        viewModel.navigateToSelectedTProperty.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                val tMovieIntent = Intent(requireContext(), MovieDetail::class.java)
                val movieId = it.id
                tMovieIntent.putExtra(MovieDetail.movie_id, movieId);
                startActivity(tMovieIntent)
                viewModel.displayTrendingMoviePropertyDetailsComplete()
            }
        })
        /*NowPlaying Shows Recycler View Adapter*/
        binding.nowPlayingShowsRecyclerView.adapter =
            NowPlayingShowsAdapter(NowPlayingShowsAdapter.OnClickListener {
                viewModel.displayNPShowPropertyDetails(it)
            })
        viewModel.navigateToSelectedNSProperty.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                val showIntent = Intent(requireContext(), ShowDetail::class.java)
                val showId = it.id
                showIntent.putExtra(ShowDetail.show_id,showId);
                startActivity(showIntent)
                viewModel.displayNPShowPropertyDetailsComplete()
            }
        })
        /*Trending Shows Recycler View Adapter*/
        binding.trendingShowsRv.adapter = TrendingShowsAdapter(TrendingShowsAdapter.OnClickListener{
            viewModel.displayTrendingShowPropertyDetails(it)
        })
        viewModel.navigateToSelectedTSProperty.observe(viewLifecycleOwner, Observer {
            if (null != it) {
                val showIntent = Intent(requireContext(), ShowDetail::class.java)
                val showId = it.id
                showIntent.putExtra(ShowDetail.show_id,showId);
                startActivity(showIntent)
                viewModel.displayTrendingShowPropertyDetailsComplete()
            }
        })
        return binding.root
    }

}