package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.detailtvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.CatalogueRepository
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.DummyData
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import kotlin.collections.ArrayList

@RunWith(MockitoJUnitRunner::class)
class DetailTvShowViewModelTest {
    
    lateinit var detailTvShowViewModel: DetailTvShowViewModel
    lateinit var dummyTvShows: ArrayList<TvShow>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var catalogueRepository: CatalogueRepository

    @Mock
    lateinit var observer: Observer<TvShow?>

    @Before
    fun setUp() {
        detailTvShowViewModel = DetailTvShowViewModel(catalogueRepository)
    }

    @Test
    fun testGetTvShow() {
        dummyTvShows = DummyData.generateDummyTvShow()
        val mDummyTvShow: TvShow = dummyTvShows[0]

        val tvShows = MutableLiveData<TvShow>()
        tvShows.value = dummyTvShows[0]

        `when`(catalogueRepository.getDetailTvShow(1)).thenReturn(tvShows)

        detailTvShowViewModel.getTvShow(1).observeForever(observer)
        verify(observer).onChanged(mDummyTvShow)

        val detailTvShow = detailTvShowViewModel.getTvShow(1).value as TvShow

        Assert.assertNotNull(detailTvShow)
        Assert.assertEquals(detailTvShow.tvShowId.toLong(), mDummyTvShow.tvShowId.toLong())
        Assert.assertEquals(detailTvShow.tvShowTitle, mDummyTvShow.tvShowTitle)
        Assert.assertEquals(detailTvShow.tvShowPoster.toLong(), mDummyTvShow.tvShowPoster.toLong())
        Assert.assertEquals(detailTvShow.tvShowGenre, mDummyTvShow.tvShowGenre)
        Assert.assertEquals(detailTvShow.tvShowDescription, mDummyTvShow.tvShowDescription)
        Assert.assertEquals(detailTvShow.tvShowYear, mDummyTvShow.tvShowYear)
    }
}