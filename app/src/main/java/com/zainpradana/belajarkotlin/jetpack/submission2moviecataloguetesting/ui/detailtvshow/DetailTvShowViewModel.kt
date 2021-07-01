package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.detailtvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.CatalogueRepository
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.TvShow

class DetailTvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getTvShow(tvShowId: Int) : LiveData<TvShow> = catalogueRepository.getDetailTvShow(tvShowId)

    fun saveTvShow(tvShow: TvShow, isFavorite: Boolean) = catalogueRepository.setFavoriteTvShow(tvShow = tvShow, state = isFavorite)
}