package com.example.exploreentertainment.adapters.showsadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.PopularShowItemBinding
import com.example.exploreentertainment.network.models.shows.PopularShow

class PopularShowsAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<PopularShow, PopularShowsAdapter.PopularShowViewHolder>(
        DiffCallback
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularShowViewHolder {
        return PopularShowViewHolder(
            PopularShowItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: PopularShowViewHolder, position: Int) {
        val pShow = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(pShow)
        }
        holder.bind(pShow)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<PopularShow>() {
        override fun areItemsTheSame(oldItem: PopularShow, newItem: PopularShow): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: PopularShow, newItem: PopularShow): Boolean {
            return oldItem.imgUrl == newItem.imgUrl
        }
    }

    class PopularShowViewHolder(private val binding: PopularShowItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(popularShow: PopularShow) {
            binding.property = popularShow
            binding.executePendingBindings()
        }
    }

    class OnClickListener(val clickListener: (popularShow: PopularShow) -> Unit) {
        fun onClick(popularShow: PopularShow) = clickListener(popularShow)
    }


}