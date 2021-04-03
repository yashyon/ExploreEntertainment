package com.example.exploreentertainment.adapters.nowplayingAdapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.NowPlayingShowItemBinding
import com.example.exploreentertainment.network.models.NowPlayingShow

class NowPlayingShowsAdapter  : ListAdapter<NowPlayingShow, NowPlayingShowsAdapter.NowPlayingShowsViewHolder>(
    DiffCallback
){

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): NowPlayingShowsViewHolder {
        return NowPlayingShowsViewHolder(
            NowPlayingShowItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: NowPlayingShowsViewHolder, position: Int) {
        val npmovie = getItem(position)
        holder.bind(npmovie)
    }

    companion object DiffCallback : DiffUtil.ItemCallback<NowPlayingShow>() {
        override fun areItemsTheSame(oldItem: NowPlayingShow, newItem: NowPlayingShow): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: NowPlayingShow, newItem: NowPlayingShow): Boolean {
            return oldItem.imgUrl2 == newItem.imgUrl2
        }
    }

    class NowPlayingShowsViewHolder(private val binding : NowPlayingShowItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(npMovies : NowPlayingShow){
            binding.property = npMovies
            binding.executePendingBindings()
        }
    }
}