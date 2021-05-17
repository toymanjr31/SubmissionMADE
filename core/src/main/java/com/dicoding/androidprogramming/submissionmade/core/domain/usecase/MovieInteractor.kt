package com.dicoding.androidprogramming.submissionmade.core.domain.usecase

import com.dicoding.androidprogramming.submissionmade.core.domain.model.Movies
import com.dicoding.androidprogramming.submissionmade.core.domain.repository.IMovieRepository

class MovieInteractor(private val movieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovies() = movieRepository.getAllMovies()

    override fun getFavoriteMovies() = movieRepository.getFavoriteMovies()

    override fun setFavoriteMovies(movies: Movies, state: Boolean) = movieRepository.setFavoriteMovies(movies, state)
}