package com.dicoding.androidprogramming.submissionmade.core.domain.repository

import com.dicoding.androidprogramming.submissionmade.core.data.Resource
import com.dicoding.androidprogramming.submissionmade.core.domain.model.Movies
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovies(): Flow<Resource<List<Movies>>>

    fun getFavoriteMovies(): Flow<List<Movies>>

    fun setFavoriteMovies(movies: Movies, state: Boolean)

}