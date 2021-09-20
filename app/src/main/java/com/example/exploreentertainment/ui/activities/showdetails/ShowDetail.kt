package com.example.exploreentertainment.ui.activities.showdetails

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.exploreentertainment.R
import com.example.exploreentertainment.databinding.ActivityShowDetailsBinding

class ShowDetail : AppCompatActivity() {
    companion object {
        const val show_id: String = ""
    }

    private lateinit var viewModel: ShowDetailsViewModel
    private lateinit var viewModelFactory: ShowDetailsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_details)
        val showId = intent.getIntExtra(ShowDetail.show_id, 0)
        val binding: ActivityShowDetailsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_show_details)
        viewModelFactory = ShowDetailsViewModelFactory(showId)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ShowDetailsViewModel::class.java)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        viewModel.showDetails.observe(this,{
            if(it!=null){
                binding.movieTitle.text = viewModel.showDetails.value?.title
                binding.movieOverview.text = viewModel.showDetails.value?.overview
                binding.releasedDate.text = viewModel.showDetails.value?.releasedDate
                val color = viewModel.showDetails.value?.ratingText
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









