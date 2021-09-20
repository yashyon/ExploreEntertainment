package com.example.exploreentertainment.adapters.trendingadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.TrendingShowItemBinding
import com.example.exploreentertainment.network.models.TrendingShow
import com.example.exploreentertainment.network.models.trending.TrendingMovie

class TrendingShowsAdapter(private val onClickListener: OnClickListener)  : ListAdapter<TrendingShow, TrendingShowsAdapter.TrendingShowsViewHolder>(
DiffCallback
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TrendingShowsViewHolder {
        return TrendingShowsViewHolder(
            TrendingShowItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: TrendingShowsViewHolder, position: Int) {
        val tShow = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(tShow)
        }
        holder.bind(tShow)
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
    class OnClickListener(val clickListener: (trendingShow: TrendingShow) -> Unit) {
        fun onClick(trendingShow: TrendingShow) = clickListener(trendingShow)
    }
}