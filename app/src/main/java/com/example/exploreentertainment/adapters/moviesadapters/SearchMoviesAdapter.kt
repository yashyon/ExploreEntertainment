package com.example.exploreentertainment.adapters.moviesadapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exploreentertainment.databinding.MovieSearchItemBinding
import com.example.exploreentertainment.network.models.movies.SearchMovie

class SearchMoviesAdapter  : RecyclerView.Adapter<SearchMoviesAdapter.SearchMoviesViewHolder>() {

    private val movies : ArrayList<SearchMovie> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int):SearchMoviesViewHolder {
        return SearchMoviesViewHolder(
            MovieSearchItemBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }
    override fun getItemCount(): Int{
        return movies.size
    }

    override fun onBindViewHolder(holder: SearchMoviesAdapter.SearchMoviesViewHolder, position: Int) {
        val recentMovie = movies[position]
        holder.bind(recentMovie)
    }

    class SearchMoviesViewHolder(private val binding : MovieSearchItemBinding)
        : RecyclerView.ViewHolder(binding.root){
        fun bind(movie : SearchMovie){
            binding.text.text = movie.name
            binding.executePendingBindings()
        }
    }

    fun updateList(arraylist : ArrayList<SearchMovie>) {
        this.movies.clear()
        this.movies.addAll(arraylist)
        notifyDataSetChanged()
    }
}