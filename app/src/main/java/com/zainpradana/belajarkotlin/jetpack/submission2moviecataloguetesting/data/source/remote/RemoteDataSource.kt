package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote.response.MovieResponse
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote.response.TvShowResponse
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.DummyData
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.EspressoIdlingResource

class RemoteDataSource private constructor(private val dummyData: DummyData) {

    private val handler = Handler(Looper.getMainLooper())

    companion object {
        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000

        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(dummyData: DummyData): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(dummyData).apply { instance = this }
            }
    }

    fun getListMovies(): LiveData<ApiResponse<List<MovieResponse>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<MovieResponse>>>()
        handler.postDelayed({
            resultMovies.value = ApiResponse.success(dummyData.generateRemoteDummyMovies())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultMovies
    }


    fun getListTvShows(): LiveData<ApiResponse<List<TvShowResponse>>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShowResponse>>>()
        handler.postDelayed({
            resultTvShows.value = ApiResponse.success(dummyData.generateRemoteDummyTvShow())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS)
        return resultTvShows
    }
}

