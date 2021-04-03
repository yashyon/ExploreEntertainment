package com.example.exploreentertainment.adapters.moviesadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.adapters.nowplayingAdapters.NowPlayingMoviesAdapter
import com.example.exploreentertainment.databinding.NowPlayingMovieItemBinding
import com.example.exploreentertainment.databinding.RecentMoviesItemBinding
import com.example.exploreentertainment.network.models.NowPlayingMovie
import com.example.exploreentertainment.network.models.movies.RecentMovie

class RecentMoviesAdapter  : ListAdapter<RecentMovie, RecentMoviesAdapter.RecentMoviesViewHolder>(
    DiffCallback
){

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): RecentMoviesViewHolder {
        return RecentMoviesViewHolder(
            RecentMoviesItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }
    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: RecentMoviesAdapter.RecentMoviesViewHolder, position: Int) {
        val recentMovie = getItem(position)
        holder.bind(recentMovie)
    }

    companion object DiffCallback : DiffUtil.ItemCallback< RecentMovie >() {
        override fun areItemsTheSame(oldItem: RecentMovie, newItem: RecentMovie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: RecentMovie, newItem: RecentMovie): Boolean {
            return oldItem.imgUrl == newItem.imgUrl
        }
    }

    class RecentMoviesViewHolder(private val binding : RecentMoviesItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(recentMovie : RecentMovie){
            binding.property = recentMovie
            binding.executePendingBindings()
        }
    }
}