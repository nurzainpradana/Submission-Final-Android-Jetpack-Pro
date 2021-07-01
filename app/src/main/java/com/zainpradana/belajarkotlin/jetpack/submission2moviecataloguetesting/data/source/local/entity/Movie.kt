package com.zainpradana.belajarkotlin.jetpack.submission2moviecataloguetesting.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieEntity")
data class Movie(
        @PrimaryKey
        @NonNull
        @ColumnInfo(name = "movieId")
        var movieId: Int,

        @ColumnInfo(name = "moviePoster")
        var moviePoster: Int,

        @ColumnInfo(name = "movieTitle")
        var movieTitle: String,

        @ColumnInfo(name = "movieGenre")
        var movieGenre: String,

        @ColumnInfo(name = "movieDescription")
        var movieDescription: String,

        @ColumnInfo(name = "movieYear")
        var movieYear: String,

        @ColumnInfo(name = "movieSaved")
        var movieSaved: Boolean?)