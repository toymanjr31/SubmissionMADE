package com.dicoding.androidprogramming.submissionmade.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class Movies(
    val movieId: Int = 0,
    val movieTitle: String? = null,
    val movieDescription: String? = null,
    val moviePoster: String? = null,
    val movieBackdrop: String? = null,
    val movieDate: String? = null,
    val movieFavorited: Boolean = false
): Parcelable