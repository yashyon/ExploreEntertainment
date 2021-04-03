package com.example.exploreentertainment.adapters.nowplayingAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.NowPlayingMovieItemBinding
import com.example.exploreentertainment.network.models.nowplaying.NowPlayingMovie

class NowPlayingMoviesAdapter  : ListAdapter<NowPlayingMovie, NowPlayingMoviesAdapter.NowPlayingMoviesViewHolder>(
    DiffCallback
){

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): NowPlayingMoviesViewHolder {
        return NowPlayingMoviesViewHolder(NowPlayingMovieItemBinding.inflate(LayoutInflater.from(parent.context)))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: NowPlayingMoviesViewHolder, position: Int) {
        val npmovie = getItem(position)
        holder.bind(npmovie)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<NowPlayingMovie>() {
        override fun areItemsTheSame(oldItem: NowPlayingMovie, newItem: NowPlayingMovie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: NowPlayingMovie, newItem: NowPlayingMovie): Boolean {
            return oldItem.imgUrl == newItem.imgUrl
        }
    }

    class NowPlayingMoviesViewHolder(private val binding : NowPlayingMovieItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(npMovies : NowPlayingMovie){
            binding.property = npMovies
            binding.executePendingBindings()
        }
    }
}