package com.example.exploreentertainment.ui.activities.moviedetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.exploreentertainment.R
import com.example.exploreentertainment.ui.fragments.nowplaying.NowPlayingViewModel

class MovieDetail : AppCompatActivity() {

    companion object{
        const val movie_id : String = ""
    }
    private val viewModel : MovieDetailViewModel by lazy{
        ViewModelProvider(this).get(MovieDetailViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val movieId = intent.getIntExtra(movie_id,0)

    }
}




