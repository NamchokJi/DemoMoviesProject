package com.namchok.data.service

import com.namchok.data.model.GetPopularMoviesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface HomeApiInterface {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
    ): Response<GetPopularMoviesResponse>

    @GET("movie/top_rated")
    suspend fun getTopRateMovies(
        @Query("language") language: String = "en-US",
        @Query("page") page: Int = 1,
    ): Response<GetPopularMoviesResponse>
}
