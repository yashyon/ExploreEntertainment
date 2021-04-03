package com.example.exploreentertainment.ui.fragments.movies

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.exploreentertainment.R
import com.example.exploreentertainment.databinding.NowPlayingFragmentBinding
import com.example.exploreentertainment.ui.fragments.nowplaying.NowPlayingViewModel

class MoviesFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.movies_fragment, container, false)
    }


}