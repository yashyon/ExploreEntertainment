package com.example.exploreentertainment.ui.fragments.shows

import android.annotation.SuppressLint
import android.app.Activity
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.exploreentertainment.R
import com.example.exploreentertainment.adapters.moviesadapters.SearchMoviesAdapter
import com.example.exploreentertainment.adapters.showsadapters.SearchShowsAdapter
import com.example.exploreentertainment.databinding.MoviesFragmentBinding
import com.example.exploreentertainment.databinding.ShowsFragmentBinding
import com.example.exploreentertainment.ui.fragments.movies.MoviesViewModel

class ShowsFragment : Fragment() {

    private lateinit var viewModel: ShowsViewModel
    private lateinit var showsAdapter: SearchShowsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ShowsFragmentBinding.inflate(inflater)
        viewModel = ViewModelProvider(requireActivity()).get(ShowsViewModel::class.java)
        binding.lifecycleOwner = requireActivity()
        binding.viewModel = viewModel
        binding.searchShowsRv.layoutManager = LinearLayoutManager(
            context,
            LinearLayoutManager.VERTICAL,
            false
        )
        /*
        Code for Recycler View of Search
         */
        showsAdapter = SearchShowsAdapter()
        binding.searchShowsRv.adapter = showsAdapter
        binding.searchShowsRv.visibility = View.GONE
        viewModel.searchShows.observe(viewLifecycleOwner, {
            if (it.isNotEmpty()) binding.searchShowsRv.visibility = View.VISIBLE
            else {
                binding.searchShowsRv.visibility = View.GONE
            }
            showsAdapter.updateList(it)
        })

        binding.searchTextShow.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                binding.searchShowsRv.visibility = View.GONE
            } else {
                binding.searchShowsRv.visibility = View.VISIBLE
            }
        }

        binding.searchTextShow.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null) {
                    if (query.isEmpty()) {
                        binding.searchShowsRv.visibility = View.GONE
                        viewModel.fetchSearch(query)
                    } else {
                        binding.searchShowsRv.visibility = View.VISIBLE
                    }
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    binding.searchShowsRv.visibility = View.VISIBLE
                    viewModel.fetchSearch(newText)
                } else {
                    binding.searchShowsRv.visibility = View.GONE
                }
                return false
            }
        })
        setupUI(binding.parent, binding)
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
    private fun setupUI(view: View, binding: ShowsFragmentBinding) {
        val v = binding.searchShowsRv.id
        if (view !is SearchView) {
            view.setOnTouchListener { v, _ ->
                if (binding.searchTextShow.hasFocus()) {
                    hideSoftKeyboard(requireActivity())
                    binding.searchTextShow.clearFocus()
                }
                binding.searchShowsRv.visibility = View.GONE
                false
            }
        }
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerView = view.getChildAt(i)
            }
        }

    }

}