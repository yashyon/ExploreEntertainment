package com.example.exploreentertainment.ui.activities.moviedetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.exploreentertainment.R
import com.example.exploreentertainment.databinding.ActivityMovieDetailBinding
import com.example.exploreentertainment.ui.fragments.nowplaying.NowPlayingViewModel

class MovieDetail : AppCompatActivity() {

    companion object{
        const val movie_id : String = ""
    }
    public var movieId : Int = ""
    private val viewModel : MovieDetailViewModel by lazy{
        ViewModelProvider(this).get(MovieDetailViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)
        movieId = intent.getIntExtra(movie_id,0)
        val binding : ActivityMovieDetailBinding = DataBindingUtil.setContentView(this,R.layout.activity_movie_detail)
//        binding.lifecycleOwner = this
    //        val binding: ActivityCityRestaurantsBinding = DataBindingUtil.setContentView(this, R.layout.activity_city_restaurants)
//        Toast.makeText(this," this is the $movieId",Toast.LENGTH_LONG).show()
    }
}




