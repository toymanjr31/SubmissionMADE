package com.dicoding.androidprogramming.submissionmade.core.utils

import com.dicoding.androidprogramming.submissionmade.core.data.source.local.entity.MovieEntity
import com.dicoding.androidprogramming.submissionmade.core.data.source.remote.response.MovieResponse
import com.dicoding.androidprogramming.submissionmade.core.domain.model.Movies

object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie =
                MovieEntity(
                    movieId = it.id,
                    movieTitle = it.originalTitle,
                    movieDescription = it.overview,
                    moviePoster = it.posterPath,
                    movieBackdrop = it.backdrop_path,
                    movieDate = it.release_date,
                    movieFavorited = false
                )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movies> =
        input.map {
            Movies(
                movieId = it.movieId,
                movieTitle = it.movieTitle,
                movieDescription = it.movieDescription,
                moviePoster = it.moviePoster,
                movieBackdrop = it.movieBackdrop,
                movieDate = it.movieDate,
                movieFavorited = it.movieFavorited
            )
        }

    fun mapDomainToEntity(input: Movies) =
        MovieEntity(
            movieId = input.movieId,
            movieTitle = input.movieTitle,
            movieDescription = input.movieDescription,
            moviePoster = input.moviePoster,
            movieBackdrop = input.movieBackdrop,
            movieDate = input.movieDate,
            movieFavorited = input.movieFavorited
        )
}