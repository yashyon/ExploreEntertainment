package com.example.exploreentertainment.adapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.exploreentertainment.adapters.moviesadapters.PopularMoviesAdapter
import com.example.exploreentertainment.adapters.moviesadapters.RecentMoviesAdapter
import com.example.exploreentertainment.adapters.moviesadapters.TopRatedMoviesAdapter
import com.example.exploreentertainment.adapters.moviesadapters.UpComingMoviesAdapter
import com.example.exploreentertainment.adapters.nowplayingAdapters.NowPlayingMoviesAdapter
import com.example.exploreentertainment.adapters.nowplayingAdapters.NowPlayingShowsAdapter
import com.example.exploreentertainment.adapters.trendingadapters.TrendingMoviesAdapter
import com.example.exploreentertainment.adapters.trendingadapters.TrendingShowsAdapter
import com.example.exploreentertainment.databinding.TopRatedMovieItemBinding
import com.example.exploreentertainment.network.models.NowPlayingShow
import com.example.exploreentertainment.network.models.TrendingMovie
import com.example.exploreentertainment.network.models.TrendingShow
import com.example.exploreentertainment.network.models.movies.PopularMovie
import com.example.exploreentertainment.network.models.movies.RecentMovie
import com.example.exploreentertainment.network.models.movies.TopRatedMovie
import com.example.exploreentertainment.network.models.movies.UpComingMovie
import com.example.exploreentertainment.network.models.nowplaying.NowPlayingMovie

@BindingAdapter("rating")
fun bindRating(textView: TextView, rating: Int) {
    textView.text = rating.toString()
}

@BindingAdapter("mediaType")
fun bindMediaType(textView: TextView, mediaType: String) {
    textView.text = mediaType
}

@BindingAdapter("title")
fun bindTitle(textView: TextView, title: String) {
    textView.text = title
}

@BindingAdapter("date")
fun bindDate(textView: TextView, date: String) {
    textView.text = date
}

@BindingAdapter("listDataNPMovies")
fun bindNPMoviesRecyclerView(recyclerView: RecyclerView, data: List<NowPlayingMovie>?) {
    (recyclerView.adapter as? NowPlayingMoviesAdapter)?.submitList(data)
}

@BindingAdapter("listDataPopularMovies")
fun bindPopularMoviesRecyclerView(recyclerView: RecyclerView, data: List<PopularMovie>?) {
    (recyclerView.adapter as? PopularMoviesAdapter)?.submitList(data)
}

@BindingAdapter("listDataNPShows")
fun bindNPShowsRecyclerView(recyclerView: RecyclerView, data: List<NowPlayingShow>?) {
    (recyclerView.adapter as? NowPlayingShowsAdapter)?.submitList(data)
}

@BindingAdapter("listDataTopRatedMovies")
fun bindTopRatedRecyclerView(recyclerView: RecyclerView, data: List<TopRatedMovie>?) {
    (recyclerView.adapter as? TopRatedMoviesAdapter)?.submitList(data)
}

@BindingAdapter("listDataUpComingMovies")
fun bindUpComingMoviesRecyclerView(recyclerView: RecyclerView, data: List<UpComingMovie>?) {
    (recyclerView.adapter as? UpComingMoviesAdapter)?.submitList(data)
}

@BindingAdapter("listDataRecentMovies")
fun bindRecentMoviesRecyclerView(recyclerView: RecyclerView, data: List<RecentMovie>?) {
    (recyclerView.adapter as? RecentMoviesAdapter)?.submitList(data)
}

@BindingAdapter("listDataTrendingShows")
fun bindTrendingShowsRecyclerView(recyclerView: RecyclerView, data: List<TrendingShow>?) {
    (recyclerView.adapter as? TrendingShowsAdapter)?.submitList(data)
}

@BindingAdapter("listDataTrendingMovies")
fun bindTrendingMoviesRecyclerView(recyclerView: RecyclerView, data: List<TrendingMovie>?) {
    (recyclerView.adapter as? TrendingMoviesAdapter)?.submitList(data)
}


@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val url = "https://image.tmdb.org/t/p/w500$imgUrl"
        Glide.with(imageView.context).load(url).into(imageView)
    }
}



