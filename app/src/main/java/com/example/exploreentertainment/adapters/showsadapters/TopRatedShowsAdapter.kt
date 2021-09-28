package com.example.exploreentertainment.adapters.showsadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.TopRatedShowItemBinding
import com.example.exploreentertainment.network.models.shows.TopRatedShow

class TopRatedShowsAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<TopRatedShow, TopRatedShowsAdapter.TopRatedShowsViewHolder>(
        TopRatedShowsAdapter
    )  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopRatedShowsViewHolder {
        return TopRatedShowsViewHolder(
            TopRatedShowItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: TopRatedShowsViewHolder, position: Int) {
        val topRatedShow = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(topRatedShow)
        }
        holder.bind(topRatedShow)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<TopRatedShow>() {
        override fun areItemsTheSame(oldItem: TopRatedShow, newItem: TopRatedShow): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: TopRatedShow, newItem: TopRatedShow): Boolean {
            return oldItem.imgUrl == newItem.imgUrl
        }
    }

    class TopRatedShowsViewHolder(private val binding: TopRatedShowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(topRatedShow: TopRatedShow) {
            binding.property = topRatedShow
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (topRatedShow: TopRatedShow) -> Unit) {
        fun onClick(topRatedShow: TopRatedShow) = clickListener(topRatedShow)
    }


}