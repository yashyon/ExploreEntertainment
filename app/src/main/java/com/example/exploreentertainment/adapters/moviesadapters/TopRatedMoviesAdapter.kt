package com.example.exploreentertainment.adapters.moviesadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.PopularMovieItemBinding
import com.example.exploreentertainment.databinding.TopRatedMovieItemBinding
import com.example.exploreentertainment.network.models.movies.PopularMovie
import com.example.exploreentertainment.network.models.movies.TopRatedMovie

class TopRatedMoviesAdapter :
    ListAdapter<TopRatedMovie, TopRatedMoviesAdapter.TopRatedMoviesViewHolder>(
        DiffCallback
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TopRatedMoviesViewHolder {
        return TopRatedMoviesViewHolder(
            TopRatedMovieItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(
        holder: TopRatedMoviesAdapter.TopRatedMoviesViewHolder,
        position: Int
    ) {
        val topRatedMovie = getItem(position)
        holder.bind(topRatedMovie)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<TopRatedMovie>() {
        override fun areItemsTheSame(oldItem: TopRatedMovie, newItem: TopRatedMovie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TopRatedMovie, newItem: TopRatedMovie): Boolean {
            return oldItem.imgUrl == newItem.imgUrl
        }
    }

    class TopRatedMoviesViewHolder(private val binding: TopRatedMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(topRatedMovie: TopRatedMovie) {
            binding.property = topRatedMovie
            binding.executePendingBindings()
        }
    }
}