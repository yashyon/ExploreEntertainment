package com.example.exploreentertainment.adapters.showsadapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.MovieSearchItemBinding
import com.example.exploreentertainment.databinding.ShowSearchItemBinding
import com.example.exploreentertainment.network.models.shows.SearchShow

class SearchShowsAdapter : RecyclerView.Adapter<SearchShowsAdapter.SearchShowsViewHolder>() {

    private val shows : ArrayList<SearchShow> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchShowsViewHolder {
        return SearchShowsViewHolder(
            ShowSearchItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }

    override fun onBindViewHolder(holder: SearchShowsViewHolder, position: Int) {
        val recentShow = shows[position]
        holder.bind(recentShow)
    }

    override fun getItemCount(): Int {
        return shows.size
    }

    fun updateList(arraylist : ArrayList<SearchShow>) {
        this.shows.clear()
        this.shows.addAll(arraylist)
        notifyDataSetChanged()
    }

    class SearchShowsViewHolder(private val binding : ShowSearchItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(show : SearchShow){
            binding.text.text = show.name
            binding.executePendingBindings()
        }
    }
}