package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.DataSource.Factory
import com.nhaarman.mockitokotlin2.verify
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.LocalDataSource
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote.FakeCatalogueRepository
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote.RemoteDataSource
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.AppExecutors
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.DummyData
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.LiveDataTestUtil
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.PagedListUtil
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.*

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = mock(RemoteDataSource::class.java)
    private val local: LocalDataSource = mock(LocalDataSource::class.java)
    private val appExecutors: AppExecutors = mock(AppExecutors::class.java)

    private val catalogueRepository = FakeCatalogueRepository(
            remoteDataSource = remote,
            localDataSource = local,
            appExecutors = appExecutors)


    private val moviesResponse = DummyData.generateRemoteDummyMovies()
    private val movieId = moviesResponse[0].movieId

    private val tvShowsResponse = DummyData.generateRemoteDummyTvShow()
    private val tvShowId = tvShowsResponse[0].tvShowId



    @Test
    fun getListMovies() {
        val dataSourceFactory: Factory<Int, Movie> = mock(Factory::class.java) as Factory<Int, Movie>
        `when`(local.getAllMovie()).thenReturn(dataSourceFactory)
        catalogueRepository.getListMovies()

        val listMovie = Resource.success(PagedListUtil.mockPagedList(DummyData.generateDummyMovies()))
        verify(local).getAllMovie()

        assertNotNull(listMovie)
        listMovie.data?.size?.let { assertEquals(it.toLong(), moviesResponse.size.toLong()) }

    }

    @Test
    fun getListTvShow() {
        val dataSourceFactory: Factory<Int, TvShow> = mock(Factory::class.java) as Factory<Int, TvShow>
        `when`(local.getAllTvShow()).thenReturn(dataSourceFactory)
        catalogueRepository.getListTvShow()

        val listTvShow = Resource.success(PagedListUtil.mockPagedList(DummyData.generateRemoteDummyTvShow()))
        verify(local).getAllTvShow()

        assertNotNull(listTvShow)
        listTvShow.data?.size?.let { assertEquals(it.toLong(), tvShowsResponse.size.toLong()) }

    }

    @Test
    fun getListFavoriteMovies() {
        val dataSourceFactory = MutableLiveData<List<Movie>>()
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        catalogueRepository.getFavoriteMovie()

        val listMovie = Resource.success(PagedListUtil.mockPagedList(DummyData.generateDummyMovies()))
        verify(local).getFavoriteMovies()

        assertNotNull(listMovie)
        listMovie.data?.size?.let { assertEquals(it.toLong(), moviesResponse.size.toLong()) }

    }

    @Test
    fun getListFavoriteTvShow() {
        val dataSourceFactory = MutableLiveData<List<TvShow>>()
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        catalogueRepository.getFavoriteTvShow()

        val listTvShow = Resource.success(PagedListUtil.mockPagedList(DummyData.generateRemoteDummyTvShow()))
        verify(local).getFavoriteTvShows()

        assertNotNull(listTvShow)
        listTvShow.data?.size?.let { assertEquals(it.toLong(), tvShowsResponse.size.toLong()) }

    }

    @Test
    fun getDetailTvShow() {
        val tvShowDetail = MutableLiveData<TvShow>()
        `when`(local.getDetailTvShow("1")).thenReturn(tvShowDetail)
        catalogueRepository.getDetailTvShow(1)

        val detailTvShows = Resource.success(PagedListUtil.mockPagedList(DummyData.generateRemoteDummyTvShow()))
        verify(local).getDetailTvShow("1")

        assertNotNull(detailTvShows)
        assertEquals(detailTvShows.data?.get(0)?.tvShowId, tvShowId)
    }

    @Test
    fun getDetailMovie() {
        val movieDetail = MutableLiveData<Movie>()
        `when`(local.getDetailMovie("1")).thenReturn(movieDetail)
        catalogueRepository.getDetailMovie(1)

        val detailMovie = Resource.success(PagedListUtil.mockPagedList(DummyData.generateRemoteDummyMovies()))
        verify(local).getDetailMovie("1")

        assertNotNull(detailMovie)
        assertEquals(detailMovie?.data?.get(0)?.movieId, movieId)
    }
}