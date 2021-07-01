package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.remote.response

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TvShowResponse(
    var tvShowId: Int,

    var tvShowPoster: Int,

    var tvShowTitle: String,

    var tvShowGenre: String,

    var tvShowDescription: String,

    var tvShowYear: String
) : Parcelable