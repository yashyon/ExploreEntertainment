package com.example.exploreentertainment.ui.fragments.movies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager.HORIZONTAL
import com.example.exploreentertainment.R
import com.example.exploreentertainment.adapters.moviesadapters.RecentMoviesAdapter
import com.example.exploreentertainment.adapters.moviesadapters.SearchMoviesAdapter
import com.example.exploreentertainment.databinding.MoviesFragmentBinding
import com.example.exploreentertainment.databinding.NowPlayingFragmentBinding
import com.example.exploreentertainment.network.models.movies.SearchMovie
import com.example.exploreentertainment.ui.fragments.nowplaying.NowPlayingViewModel
import android.content.Intent

import android.view.MotionEvent
import android.view.View.OnTouchListener


class MoviesFragment : Fragment() {

    private lateinit var viewModel: MoviesViewModel

    private lateinit var moviesAdapter: SearchMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MoviesFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity()).get(MoviesViewModel::class.java)
        binding.lifecycleOwner = requireActivity()
        binding.viewModel = viewModel
        binding.searchMoviesRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)
        binding.recentMoviesRv.adapter = RecentMoviesAdapter()
        /*
        Code for Recycler View of Search
         */
        moviesAdapter = SearchMoviesAdapter()
        binding.searchMoviesRv.adapter = moviesAdapter
        binding.searchMoviesRv.visibility = View.GONE
        viewModel.searchMovies.observe(viewLifecycleOwner, Observer{
            moviesAdapter.updateList(it)
        })


        binding.searchTextMovie.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val currentText = binding.searchTextMovie.text.toString()
                if(currentText!=null){
                    viewModel.fetchSearch(currentText)
                }
                else binding.searchMoviesRv.visibility = View.GONE
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })

        binding.searchTextMovie.setOnTouchListener(object : OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                if(binding.searchTextMovie.text!=null){
                    Log.e("Fragment", "Recycler view appeared")
                    binding.searchMoviesRv.visibility = View.VISIBLE
                }
                else binding.searchMoviesRv.visibility = View.GONE
                return v?.onTouchEvent(event) ?: true
            }
        })

//        binding.searchTextMovie.onFocusChangeListener =
//            View.OnFocusChangeListener { v, hasFocus ->
//                if(hasFocus){
//                    Log.e("Fragment", "Recycler view appeared")
//                    binding.searchMoviesRv.visibility = View.VISIBLE
//                }
//                else{
//                    Log.e("Fragment", "Recycler view appeared")
//                    binding.searchMoviesRv.visibility = View.GONE
//                }
//            }
        return binding.root
        binding.searchTextMovie.setOnTouchListener(OnTouchListener { v, event ->

            true
        })

    }


}