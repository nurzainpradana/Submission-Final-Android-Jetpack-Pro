package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.room.CatalogueDao

class LocalDataSource private constructor(private val mCatalogDao: CatalogueDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(catalogDao: CatalogueDao): LocalDataSource =
            INSTANCE ?: LocalDataSource(catalogDao)
    }

//    fun getAllMovie(): LiveData<List<Movie>> = mCatalogDao.getMovies()
//    fun getAllTvShow(): LiveData<List<TvShow>> = mCatalogDao.getTvShows()
//
//    fun getFavoriteMovies(): LiveData<List<Movie>> = mCatalogDao.getSavedMovie()
//    fun getFavoriteTvShows(): LiveData<List<TvShow>> = mCatalogDao.getSavedTvShow()

    fun getAllMovie(): DataSource.Factory<Int, Movie> = mCatalogDao.getMovies()
    fun getAllTvShow(): DataSource.Factory<Int, TvShow> = mCatalogDao.getTvShows()

    fun getFavoriteMovies(): LiveData<List<Movie>> = mCatalogDao.getSavedMovie()
    fun getFavoriteTvShows(): LiveData<List<TvShow>> = mCatalogDao.getSavedTvShow()

    fun getDetailMovie(movieId: String): LiveData<Movie> =
        mCatalogDao.getDetailMovie(movieId)

    fun getDetailTvShow(tvShowId: String): LiveData<TvShow> =
        mCatalogDao.getDetailTvShow(tvShowId)

    fun setFavoriteMovie(movie: Movie, newState: Boolean) {
        movie.movieSaved = newState
        mCatalogDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShow, newState: Boolean) {
        tvShow.tvShowSaved = newState
        mCatalogDao.updateTvShow(tvShow)
    }

    fun insertMovie(movie: List<Movie>) = mCatalogDao.insertMovie(movie)
    fun insertTvShow(tvShow: List<TvShow>) = mCatalogDao.insertTvShow(tvShow)

}