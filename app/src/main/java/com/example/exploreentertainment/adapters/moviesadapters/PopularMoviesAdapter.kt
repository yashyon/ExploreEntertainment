package com.example.exploreentertainment.adapters.moviesadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.PopularMovieItemBinding
import com.example.exploreentertainment.network.models.movies.PopularMovie

class PopularMoviesAdapter :
    ListAdapter<PopularMovie, PopularMoviesAdapter.PopularMoviesViewHolder>(
        DiffCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PopularMoviesViewHolder {
        return PopularMoviesViewHolder(
            PopularMovieItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(
        holder: PopularMoviesAdapter.PopularMoviesViewHolder,
        position: Int
    ) {
        val popularMovie = getItem(position)
        holder.bind(popularMovie)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PopularMovie>() {
        override fun areItemsTheSame(oldItem: PopularMovie, newItem: PopularMovie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PopularMovie, newItem: PopularMovie): Boolean {
            return oldItem.imgUrl == newItem.imgUrl
        }
    }

    class PopularMoviesViewHolder(private val binding: PopularMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(popularMovie: PopularMovie) {
            binding.property = popularMovie
            binding.executePendingBindings()
        }
    }
}