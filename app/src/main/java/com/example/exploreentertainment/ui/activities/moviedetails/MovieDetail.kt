package com.example.exploreentertainment.ui.activities.moviedetails

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.exploreentertainment.R
import com.example.exploreentertainment.databinding.ActivityMovieDetailBinding
import com.example.exploreentertainment.databinding.NowPlayingFragmentBinding
import com.example.exploreentertainment.ui.fragments.nowplaying.NowPlayingViewModel

class MovieDetail : AppCompatActivity() {

    companion object {
        const val movie_id: String = ""
    }

    private lateinit var viewModel: MovieDetailViewModel
    private lateinit var viewModelFactory: MovieDetailViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        val movieId = intent.getIntExtra(movie_id, 0)
        val binding: ActivityMovieDetailBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_movie_detail)
        viewModelFactory = MovieDetailViewModelFactory(movieId)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MovieDetailViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.movieDetails.observe(this,{
            if(it!=null){
                binding.movieTitle.text = viewModel.movieDetails.value?.title
                binding.movieOverview.text = viewModel.movieDetails.value?.overview
                binding.releasedDate.text = viewModel.movieDetails.value?.releasedDate
                val color = viewModel.movieDetails.value?.ratingText
                binding.ratingText.text = color
                val c = color?.toDouble()
                if (c != null) {
                    if(c in 8.0..10.0){
                        binding.movieRatingCard.setBackgroundColor(Color.parseColor("#009900"))
                    } else if(c>=7.0 && c<8.0){
                        binding.movieRatingCard.setBackgroundColor(Color.parseColor("#ff9900"))
                    } else if(c>=4.0 && c<6.0){
                        binding.movieRatingCard.setBackgroundColor(Color.parseColor("#ffcc00"))
                    } else{
                        binding.movieRatingCard.setBackgroundColor(Color.parseColor("#ff0000"))
                    }
                }
            }
        })
    }

}




