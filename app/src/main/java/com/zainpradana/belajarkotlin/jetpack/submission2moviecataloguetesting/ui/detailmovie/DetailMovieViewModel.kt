package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.detailmovie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.CatalogueRepository
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.Movie

class DetailMovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getDetailMovie(movieId: Int): LiveData<Movie> = catalogueRepository.getDetailMovie(movieId)

    fun saveMovie(movie: Movie, isFavorite: Boolean) = catalogueRepository.setFavoriteMovie(movie, isFavorite)

}