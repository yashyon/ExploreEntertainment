package com.example.exploreentertainment.adapters.trendingadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.TrendingMovieItemBinding
import com.example.exploreentertainment.network.models.trending.TrendingMovie

class TrendingMoviesAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<TrendingMovie, TrendingMoviesAdapter.TrendingMoviesViewHolder>(
        DiffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int ): TrendingMoviesViewHolder {

        return TrendingMoviesViewHolder(
            TrendingMovieItemBinding.inflate( LayoutInflater.from(parent.context)
            )
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: TrendingMoviesViewHolder, position: Int) {
        val tMovie = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(tMovie)
        }
        holder.bind(tMovie)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<TrendingMovie>() {
        override fun areItemsTheSame(oldItem: TrendingMovie, newItem: TrendingMovie): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TrendingMovie, newItem: TrendingMovie): Boolean {
            return oldItem.imgUrl == newItem.imgUrl
        }
    }

    class TrendingMoviesViewHolder(private val binding: TrendingMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tMovies: TrendingMovie) {
            binding.property = tMovies
            binding.executePendingBindings()
        }
    }
    class OnClickListener(val clickListener: (trendingMovie: TrendingMovie) -> Unit) {
        fun onClick(trendingMovie: TrendingMovie) = clickListener(trendingMovie)
    }
}