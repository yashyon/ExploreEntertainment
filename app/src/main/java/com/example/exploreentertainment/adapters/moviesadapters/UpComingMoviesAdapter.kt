package com.example.exploreentertainment.adapters.moviesadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.TopRatedMovieItemBinding
import com.example.exploreentertainment.databinding.UpcomingMovieItemBinding
import com.example.exploreentertainment.network.models.movies.TopRatedMovie
import com.example.exploreentertainment.network.models.movies.UpComingMovie

class UpComingMoviesAdapter :
    ListAdapter<UpComingMovie, UpComingMoviesAdapter.UpComingMoviesViewHolder>(
        DiffCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UpComingMoviesViewHolder {
        return UpComingMoviesViewHolder(
            UpcomingMovieItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(
        holder: UpComingMoviesAdapter.UpComingMoviesViewHolder,
        position: Int
    ) {
        val upComingMovie = getItem(position)
        holder.bind(upComingMovie)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<UpComingMovie>() {
        override fun areItemsTheSame(oldItem: UpComingMovie, newItem: UpComingMovie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: UpComingMovie, newItem: UpComingMovie): Boolean {
            return oldItem.imgUrl == newItem.imgUrl
        }
    }

    class UpComingMoviesViewHolder(private val binding: UpcomingMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(upComingMovie: UpComingMovie) {
            binding.property = upComingMovie
            binding.executePendingBindings()
        }
    }
}