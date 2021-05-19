package com.dicoding.androidprogramming.submissionmade.core.data.source.local


import com.dicoding.androidprogramming.submissionmade.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: com.dicoding.androidprogramming.submissionmade.core.data.source.local.room.MovieDao) {

    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getAllMovies()

    fun getFavoriteMovies(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovies()

    suspend fun insertMovies(movieList: List<MovieEntity>) = movieDao.insertMovies(movieList)

    fun setFavoriteMovies(movie: MovieEntity, newState: Boolean) {
        movie.movieFavorited = newState
        movieDao.updateFavoriteMovies(movie)
    }
}