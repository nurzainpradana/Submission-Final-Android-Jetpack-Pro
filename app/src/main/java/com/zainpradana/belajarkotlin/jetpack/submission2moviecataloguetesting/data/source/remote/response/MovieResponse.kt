package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieResponse(
    var movieId: Int,

    var moviePoster: Int,

    var movieTitle: String,

    var movieGenre: String,

    var movieDescription: String,

    var movieYear: String
) :  Parcelable