package com.dicoding.androidprogramming.submissionmade.detail

import androidx.lifecycle.ViewModel
import com.dicoding.androidprogramming.submissionmade.core.domain.model.Movies
import com.dicoding.androidprogramming.submissionmade.core.domain.usecase.MovieUseCase

class DetailMovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovies(movies: Movies, newStatus:Boolean) =
        movieUseCase.setFavoriteMovies(movies, newStatus)
}