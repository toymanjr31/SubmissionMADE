package com.dicoding.androidprogramming.submissionmade.core.data.source.remote.network

import com.dicoding.androidprogramming.submissionmade.core.data.source.remote.response.ListMovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("movie/popular")
    suspend fun getMovieList(
        @Query("api_key") apiKey: String = "2d211ba448d2df96a2f1b2d8c631025f"
    ) :ListMovieResponse
}