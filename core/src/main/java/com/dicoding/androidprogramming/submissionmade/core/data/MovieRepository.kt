package com.dicoding.androidprogramming.submissionmade.core.data

import com.dicoding.androidprogramming.submissionmade.core.data.source.remote.network.ApiResponse
import com.dicoding.androidprogramming.submissionmade.core.data.source.remote.response.MovieResponse
import com.dicoding.androidprogramming.submissionmade.core.domain.model.Movies
import com.dicoding.androidprogramming.submissionmade.core.domain.repository.IMovieRepository
import com.dicoding.androidprogramming.submissionmade.core.utils.AppExecutors
import com.dicoding.androidprogramming.submissionmade.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val remoteDataSource: com.dicoding.androidprogramming.submissionmade.core.data.source.remote.RemoteDataSource,
    private val localDataSource: com.dicoding.androidprogramming.submissionmade.core.data.source.local.LocalDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override fun getAllMovies(): Flow<Resource<List<Movies>>> =
        object : com.dicoding.androidprogramming.submissionmade.core.data.NetworkBoundResource<List<Movies>, List<MovieResponse>>() {
            override fun loadFromDB(): Flow<List<Movies>> {
                return localDataSource.getAllMovies().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movies>?): Boolean =
                data == null || data.isEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<MovieResponse>>> =
                remoteDataSource.getAllMovies()

            override suspend fun saveCallResult(data: List<MovieResponse>) {
                val movieList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertMovies(movieList)
            }
        }.asFlow()

    override fun getFavoriteMovies(): Flow<List<Movies>> {
        return localDataSource.getFavoriteMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteMovies(movies: Movies, state: Boolean) {
        val tourismEntity = DataMapper.mapDomainToEntity(movies)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovies(tourismEntity, state) }
    }
}