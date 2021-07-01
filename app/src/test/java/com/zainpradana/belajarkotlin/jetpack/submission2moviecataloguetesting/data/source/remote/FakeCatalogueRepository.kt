package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.CatalogueDataSource
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.NetworkBoundResource
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.LocalDataSource
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.Movie
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity.TvShow
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote.response.MovieResponse
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote.response.TvShowResponse
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.util.AppExecutors
import com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.vo.Resource

class FakeCatalogueRepository(
        private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource,
        private val appExecutors: AppExecutors
) : CatalogueDataSource {

    override fun getListMovies(): LiveData<Resource<PagedList<Movie>>> {
        return object : NetworkBoundResource<PagedList<Movie>, List<MovieResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<Movie>> {
//                localDataSource.getAllMovie()
                val config = PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build()

                return LivePagedListBuilder(localDataSource.getAllMovie(), config).build()

            }


            override fun shouldFetch(data: PagedList<Movie>?): Boolean =
                    data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<MovieResponse>>> =
                    remoteDataSource.getListMovies()

            public override fun saveCallResult(data: List<MovieResponse>) {
                val movieList = ArrayList<Movie>()
                for (mv in data) {
                    val movie = Movie(
                            movieId = mv.movieId,
                            movieTitle = mv.movieTitle,
                            movieDescription = mv.movieDescription,
                            movieGenre = mv.movieGenre,
                            moviePoster = mv.moviePoster,
                            movieYear = mv.movieYear,
                            movieSaved = false
                    )
                    movieList.add(movie)
                }

                localDataSource.insertMovie(movieList)
            }
        }.asLiveData()
    }

    override fun getListTvShow(): LiveData<Resource<PagedList<TvShow>>> {
        return object : NetworkBoundResource<PagedList<TvShow>, List<TvShowResponse>>(appExecutors) {
            public override fun loadFromDB(): LiveData<PagedList<TvShow>> {
//                localDataSource.getAllTvShow()
                val config = PagedList.Config.Builder()
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(4)
                        .setPageSize(4)
                        .build()

                return LivePagedListBuilder(localDataSource.getAllTvShow(), config).build()

            }

            override fun shouldFetch(data: PagedList<TvShow>?): Boolean =
                    data == null || data.isEmpty()

            public override fun createCall(): LiveData<ApiResponse<List<TvShowResponse>>> =
                    remoteDataSource.getListTvShows()

            public override fun saveCallResult(data: List<TvShowResponse>) {
                val tvShowList = ArrayList<TvShow>()
                for (tv in data) {
                    val tvShow = TvShow(
                            tvShowId = tv.tvShowId,
                            tvShowDescription = tv.tvShowDescription,
                            tvShowGenre = tv.tvShowGenre,
                            tvShowPoster = tv.tvShowPoster,
                            tvShowTitle = tv.tvShowTitle,
                            tvShowYear = tv.tvShowYear,
                            tvShowSaved = false
                    )
                    tvShowList.add(tvShow)
                }

                localDataSource.insertTvShow(tvShowList)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(tvShowId: Int): LiveData<TvShow> {
        return localDataSource.getDetailTvShow(tvShowId.toString())
//        val detailTvShow = MutableLiveData<TvShow?>()
//        remoteDataSource.getListTvShows(object : RemoteDataSource.LoadListTvShowsCallback {
//            override fun onAllTvShowReceived(listTvShowsCallback: List<TvShow>) {
//                var tvShow: TvShow? = null
//
//                for (tv in listTvShowsCallback) {
//                    if (tv.tvShowId == tvShowId) {
//                        tvShow = TvShow(
//                                tvShowId = tv.tvShowId,
//                                tvShowYear = tv.tvShowYear,
//                                tvShowTitle = tv.tvShowTitle,
//                                tvShowPoster = tv.tvShowPoster,
//                                tvShowGenre = tv.tvShowGenre,
//                                tvShowDescription = tv.tvShowDescription
//                        )
//                    }
//                }
//                detailTvShow.postValue(tvShow)
//            }
//        })
//        return detailTvShow
    }

    override fun getDetailMovie(movieId: Int): LiveData<Movie> {
        return localDataSource.getDetailMovie(movieId.toString())
//        val detailMovie = MutableLiveData<Movie?>()
//
//        remoteDataSource.getListMovies(object : RemoteDataSource.LoadListMoviesCallback {
//            override fun onAllMoviesReceived(listMovieResponses: List<Movie>) {
//                var movie: Movie? = null
//
//                for (mv in listMovieResponses) {
//                    if (mv.movieId == movieId) {
//                        movie = Movie(
//                                movieId = mv.movieId,
//                                movieTitle = mv.movieTitle,
//                                movieDescription = mv.movieDescription,
//                                movieGenre = mv.movieGenre,
//                                moviePoster = mv.moviePoster,
//                                movieYear = mv.movieYear
//                        )
//                    }
//                }
//                detailMovie.postValue(movie)
//            }
//        })
//        return detailMovie
    }

    override fun getFavoriteMovie(): LiveData<List<Movie>> = localDataSource.getFavoriteMovies()


    override fun getFavoriteTvShow(): LiveData<List<TvShow>> = localDataSource.getFavoriteTvShows()


    override fun setFavoriteMovie(movie: Movie, state: Boolean) = appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }

    override fun setFavoriteTvShow(tvShow: TvShow, state: Boolean) = appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShow, state) }

}