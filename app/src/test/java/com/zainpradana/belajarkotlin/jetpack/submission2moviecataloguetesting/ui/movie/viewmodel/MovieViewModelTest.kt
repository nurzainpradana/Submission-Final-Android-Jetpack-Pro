package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.movie.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.CatalogueRepository
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var dummyMovies: Resource<PagedList<Movie>>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var catalogueRepository: CatalogueRepository

    @Mock
    lateinit var observer: Observer<Resource<PagedList<Movie>>>

    @Mock
    lateinit var pagedList: Resource<PagedList<Movie>>

    @Before
    fun setUp() {
        movieViewModel = MovieViewModel(catalogueRepository)
    }

    @Test
    fun getListMovie() {
        dummyMovies = pagedList

        val movies = MutableLiveData<Resource<PagedList<Movie>>>()
        val resource = dummyMovies
        movies.value = resource

        `when`(catalogueRepository.getListMovies()).thenReturn(movies)

        observer = mock(Observer::class.java) as Observer<Resource<PagedList<Movie>>>
        movieViewModel.getListMovie().observeForever(observer)
        verify(observer).onChanged(resource)

        val listMovie = movieViewModel.getListMovie().value as Resource<PagedList<Movie>>

        assertNotNull(listMovie)
        assertEquals(dummyMovies.data?.size, listMovie.data?.size)
    }
}