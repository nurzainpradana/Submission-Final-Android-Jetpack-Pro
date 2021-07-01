package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favoritemovie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.databinding.ItemCardviewMovieBinding

class CardViewFavoriteMovieAdapter internal constructor(private val listMovie: List<Movie>) : PagedListAdapter<Movie, CardViewFavoriteMovieAdapter.CardViewViewHolder>(
    DIFF_CALLBACK) {
    private var onItemClickCallback: OnItemClickCallback? = null

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.movieId == newItem.movieId
            }
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback?) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val itemCardViewMovieBinding = ItemCardviewMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewViewHolder(itemCardViewMovieBinding)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

    inner class CardViewViewHolder(private val binding: ItemCardviewMovieBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: Movie) {
            with(binding) {
                Glide.with(binding.root)
                    .load(movie.moviePoster)
                    .apply(RequestOptions().override(150, 220))
                    .into(imgMovieItemPoster)
                tvMovieItemTitle.text = movie.movieTitle
                tvMovieItemDescription.text = movie.movieDescription
                tvMovieItemGenre.text = movie.movieGenre
                tvMovieItemYear.text = movie.movieYear
                itemView.setOnClickListener {
                    onItemClickCallback?.onItemClicked(movie)
                }
            }
        }
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Movie)
    }
}