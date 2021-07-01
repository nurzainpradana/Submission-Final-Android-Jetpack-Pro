package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favoritemovie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.CatalogueRepository
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.vo.Resource

class FavoriteMovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getListFavoriteMovie() : LiveData<List<Movie>> = catalogueRepository.getFavoriteMovie()
}