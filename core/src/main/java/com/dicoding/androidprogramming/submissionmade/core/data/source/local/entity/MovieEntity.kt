package com.dicoding.androidprogramming.submissionmade.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movieentities")
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "movieId")
    var movieId: Int = 0,

    @ColumnInfo(name = "movieTitle")
    var movieTitle: String? = null,

    @ColumnInfo(name = "movieDescription")
    var movieDescription: String? = null,

    @ColumnInfo(name = "moviePoster")
    var moviePoster: String? = null,

    @ColumnInfo(name = "movieBackdrop")
    var movieBackdrop: String? = null,

    @ColumnInfo(name = "movieDate")
    var movieDate: String? = null,

    @ColumnInfo(name = "movieFavorited")
    var movieFavorited: Boolean = false
)