package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.detailmovie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.CatalogueRepository
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.DummyData
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {

    private lateinit var detailMovieViewModel: DetailMovieViewModel
    private lateinit var dummyMovies: ArrayList<Movie>


    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var catalogueRepository: CatalogueRepository

    @Mock
    lateinit var observer: Observer<Movie?>

    @Before
    fun setUp() {
        detailMovieViewModel = DetailMovieViewModel(catalogueRepository)
    }

    @Test
    fun getDetailMovie() {
        dummyMovies = DummyData.generateDummyMovies()
        val mDummyMovie: Movie = dummyMovies[0]

        val movies = MutableLiveData<Movie>()
        movies.value = dummyMovies[0]

        `when`(catalogueRepository.getDetailMovie(1)).thenReturn(movies)

        detailMovieViewModel.getDetailMovie(1).observeForever(observer)
        verify(observer).onChanged(mDummyMovie)

        val detailMovie = detailMovieViewModel.getDetailMovie(1).value as Movie

        Assert.assertNotNull(detailMovie)
        Assert.assertEquals(detailMovie.movieId.toLong(), mDummyMovie.movieId.toLong())
        Assert.assertEquals(detailMovie.movieTitle, mDummyMovie.movieTitle)
        Assert.assertEquals(detailMovie.moviePoster.toLong(), mDummyMovie.moviePoster.toLong())
        Assert.assertEquals(detailMovie.movieGenre, mDummyMovie.movieGenre)
        Assert.assertEquals(detailMovie.movieDescription, mDummyMovie.movieDescription)
        Assert.assertEquals(detailMovie.movieYear, mDummyMovie.movieYear)
    }
}