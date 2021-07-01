package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data

import androidx.lifecycle.LiveData
import androidx.paging.PagedList
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.vo.Resource

interface CatalogueDataSource {

    fun getListMovies(): LiveData<Resource<PagedList<Movie>>>

    fun getListTvShow(): LiveData<Resource<PagedList<TvShow>>>

    fun getDetailTvShow(tvShowId: Int): LiveData<TvShow>

    fun getDetailMovie(movieId: Int): LiveData<Movie>

    fun getFavoriteMovie(): LiveData<List<Movie>>
    fun getFavoriteTvShow(): LiveData<List<TvShow>>

    fun setFavoriteMovie(movie: Movie, state: Boolean)
    fun setFavoriteTvShow(tvShow: TvShow, state: Boolean)
}