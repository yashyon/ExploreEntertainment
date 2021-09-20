package com.example.exploreentertainment.ui.fragments.movies

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exploreentertainment.adapters.moviesadapters.*
import com.example.exploreentertainment.databinding.MoviesFragmentBinding
import com.example.exploreentertainment.ui.activities.MainActivity


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
        binding.searchMoviesRv.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
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
            if (it.isNotEmpty()) binding.searchMoviesRv.visibility = View.VISIBLE
            else {
                binding.searchMoviesRv.visibility = View.GONE
            }
            moviesAdapter.updateList(it)
        })

        binding.searchTextMovie.setOnFocusChangeListener { _, hasFocus ->
            if(hasFocus){
                binding.searchMoviesRv.visibility = View.GONE
            }
            else {
                binding.searchMoviesRv.visibility = View.VISIBLE
            }
        }

        binding.searchTextMovie.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    if (query.isEmpty()) {
                        binding.searchMoviesRv.visibility = View.GONE
                        viewModel.fetchSearch(query)
                    } else {
                        binding.searchMoviesRv.visibility = View.VISIBLE
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    binding.searchMoviesRv.visibility = View.VISIBLE
                    viewModel.fetchSearch(newText)
                } else {
                    binding.searchMoviesRv.visibility = View.GONE
                }
                return false
            }
        })
        setupUI(binding.parent,binding)
        return binding.root
    }

    private fun hideSoftKeyboard(activity: Activity) {
        val inputMethodManager = activity.getSystemService(
            AppCompatActivity.INPUT_METHOD_SERVICE
        ) as InputMethodManager
        if (inputMethodManager.isAcceptingText) {
            inputMethodManager.hideSoftInputFromWindow(
                activity.currentFocus!!.windowToken,
                0
            )
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun setupUI(view: View, binding: MoviesFragmentBinding) {
        val v = binding.searchMoviesRv.id
        if (view !is  SearchView) {
            view.setOnTouchListener { v, _ ->
                if(binding.searchTextMovie.hasFocus()){
                    hideSoftKeyboard(requireActivity())
                    binding.searchTextMovie.clearFocus()
                }
                binding.searchMoviesRv.visibility = View.GONE
                false
            }
        }
        if (view is ViewGroup ) {
                for (i in 0 until view.childCount) {
                    val innerView = view.getChildAt(i)
                }
        }

    }

}
