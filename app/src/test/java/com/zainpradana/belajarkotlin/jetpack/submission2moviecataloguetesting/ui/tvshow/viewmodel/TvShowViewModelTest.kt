package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.ui.tvshow.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.CatalogueRepository
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.DummyData
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var tvShowViewModel: TvShowViewModel
    private lateinit var dummyTvShows: Resource<PagedList<TvShow>>

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    lateinit var catalogueRepository: CatalogueRepository

    @Mock
    lateinit var observer: Observer<Resource<PagedList<TvShow>>>

    @Mock
    lateinit var pagedList: Resource<PagedList<TvShow>>


    @Before
    fun setUp() {
        tvShowViewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun getListTvShow() {
        dummyTvShows = pagedList

        val mTvShow = MutableLiveData<Resource<PagedList<TvShow>>>()
        val resource = dummyTvShows
        mTvShow.value = resource

        `when`(catalogueRepository.getListTvShow()).thenReturn(mTvShow)

        observer = mock(Observer::class.java) as Observer<Resource<PagedList<TvShow>>>
        tvShowViewModel.getListTvShow().observeForever(observer)
        verify(observer).onChanged(resource)

        val listTvShow = tvShowViewModel.getListTvShow().value as Resource<PagedList<TvShow>>

        assertNotNull(listTvShow)
        assertEquals(listTvShow.data?.size, dummyTvShows.data?.size)
    }
}