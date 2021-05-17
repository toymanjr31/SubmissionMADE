package com.dicoding.androidprogramming.submissionmade.core.data.source.local.room

import androidx.room.*
import com.dicoding.androidprogramming.submissionmade.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieentities")
    fun getAllMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM movieentities where movieFavorited = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Update
    fun updateFavoriteMovies(movie: MovieEntity)
}