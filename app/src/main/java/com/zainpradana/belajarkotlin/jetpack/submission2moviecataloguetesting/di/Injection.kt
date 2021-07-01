package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.di

import android.content.Context
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.CatalogueRepository
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.LocalDataSource
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.room.CatalogueDatabase
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote.RemoteDataSource
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.AppExecutors
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.DummyData

object Injection {
    fun provideRepository(context: Context): CatalogueRepository {

        val database = CatalogueDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance(DummyData)
        val localDataSource = LocalDataSource.getInstance(database.catalogueDao())
        val appExecutors = AppExecutors()

        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}