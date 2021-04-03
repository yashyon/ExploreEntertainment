package com.example.exploreentertainment.adapters.trendingadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.TrendingShowItemBinding
import com.example.exploreentertainment.network.models.TrendingShow

class TrendingShowsAdapter : ListAdapter<TrendingShow, TrendingShowsAdapter.TrendingShowsViewHolder>(
DiffCallback
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingShowsAdapter.TrendingShowsViewHolder {
        return TrendingShowsAdapter.TrendingShowsViewHolder(
            TrendingShowItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: TrendingShowsAdapter.TrendingShowsViewHolder, position: Int) {
        val tMovie = getItem(position)
        holder.bind(tMovie)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<TrendingShow>() {
        override fun areItemsTheSame(oldItem: TrendingShow, newItem: TrendingShow): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TrendingShow, newItem: TrendingShow): Boolean {
            return oldItem.imgUrl == newItem.imgUrl
        }
    }

    class TrendingShowsViewHolder(private val binding: TrendingShowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tShow: TrendingShow) {
            binding.property = tShow
            binding.executePendingBindings()
        }
    }
}