package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "tvShowEntity")
data class TvShow(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "tvShowId")
        var tvShowId: Int,

        @ColumnInfo(name = "tvShowPoster")
        var tvShowPoster: Int,

        @ColumnInfo(name = "tvShowTitle")
        var tvShowTitle: String,

        @ColumnInfo(name = "tvShowGenre")
        var tvShowGenre: String,

        @ColumnInfo(name = "tvShowDescription")
        var tvShowDescription: String,

        @ColumnInfo(name = "tvShowYear")
        var tvShowYear: String,

        @ColumnInfo(name = "tvShowSaved")
        var tvShowSaved: Boolean?)