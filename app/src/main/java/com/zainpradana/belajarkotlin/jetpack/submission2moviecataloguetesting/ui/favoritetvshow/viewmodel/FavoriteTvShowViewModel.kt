package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.favoritetvshow.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.CatalogueRepository
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.vo.Resource

class FavoriteTvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {
    fun getListFavoriteTvShow(): LiveData<List<TvShow>> = catalogueRepository.getFavoriteTvShow()
}