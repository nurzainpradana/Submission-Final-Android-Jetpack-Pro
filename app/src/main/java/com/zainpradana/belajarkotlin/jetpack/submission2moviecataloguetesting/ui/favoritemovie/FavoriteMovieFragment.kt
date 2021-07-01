package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favoritemovie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.databinding.FragmentFavoriteMovieBinding
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.detailmovie.DetailMovieActivity
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favoritemovie.adapter.CardViewFavoriteMovieAdapter
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favoritemovie.viewmodel.FavoriteMovieViewModel
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.viewmodel.ViewModelFactory
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.vo.Status

class FavoriteMovieFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMovieBinding

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFavoriteMovieBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val factory = ViewModelFactory.getInstance(requireActivity())
        val movieViewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]

        movieViewModel.getListFavoriteMovie().observe(viewLifecycleOwner, { listMovie ->
            if (listMovie != null) {
                binding.progressBar.visibility = View.GONE
                showRecyclerCardView(listMovie)
            }
        })
    }

    private fun showRecyclerCardView(movies: List<Movie>?) {
        with(binding) {
            rvMovies.setHasFixedSize(true)
            rvMovies.layoutManager = LinearLayoutManager(activity)

            val cardViewMovieAdapter = CardViewFavoriteMovieAdapter(movies!!)
            rvMovies.adapter = cardViewMovieAdapter

            cardViewMovieAdapter.setOnItemClickCallback(object : CardViewFavoriteMovieAdapter.OnItemClickCallback {
                override fun onItemClicked(data: Movie) {
                    showSelectedMovie(data)

                    val gotoDetailMovie = Intent(context, DetailMovieActivity::class.java)
                    gotoDetailMovie.putExtra(DetailMovieActivity.EXTRA_MOVIE, data.movieId)

                    startActivity(gotoDetailMovie)
                }
            })

        }
    }

    private fun showSelectedMovie(movie: Movie) {
        Toast.makeText(context, "Kamu memilih " + movie.movieTitle, Toast.LENGTH_SHORT).show()
    }
}