package com.example.exploreentertainment.ui.fragments.movies

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.MotionEvent.ACTION_DOWN
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exploreentertainment.databinding.MoviesFragmentBinding
import android.view.View.OnTouchListener
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat.getSystemService
import com.example.exploreentertainment.adapters.moviesadapters.*


class MoviesFragment : Fragment(){

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
        binding.popularMoviesRv.adapter = PopularMoviesAdapter()
        binding.topRatedMoviesRv.adapter = TopRatedMoviesAdapter()
        binding.upcomingMoviesRv.adapter = UpComingMoviesAdapter()
        /*
        Code for Recycler View of Search
         */
        moviesAdapter = SearchMoviesAdapter()
        binding.searchMoviesRv.adapter = moviesAdapter
        binding.searchMoviesRv.visibility = View.GONE
        viewModel.searchMovies.observe(viewLifecycleOwner, {
            if(it.isNotEmpty()) binding.searchMoviesRv.visibility = View.VISIBLE
            else {
                binding.frame.visibility = View.GONE
                binding.searchMoviesRv.visibility = View.GONE
            }
            moviesAdapter.updateList(it)
        })

        binding.searchTextMovie.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val currentText = binding.searchTextMovie.text.toString()
                if(currentText.isEmpty()){
                    binding.searchMoviesRv.visibility = View.GONE
                }
                else{
                    binding.searchMoviesRv.visibility = View.VISIBLE
                    binding.frame.visibility = View.VISIBLE
                }
                viewModel.fetchSearch(currentText)
            }
            override fun afterTextChanged(s: Editable?) {
            }
        })
        binding.frame.visibility = View.GONE
        binding.parentLayout.setOnFocusChangeListener{ _, hasFocus ->
            if(hasFocus){
                binding.searchMoviesRv.visibility = View.VISIBLE
                binding.frame.visibility = View.VISIBLE
            }
            else{
                Log.i("EdittextFrame","lost Focus")
                binding.searchMoviesRv.visibility = View.GONE
                binding.frame.visibility = View.GONE

            }
        }
        return binding.root
    }
    /*

    */

}