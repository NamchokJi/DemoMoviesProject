package com.namchok.data.repository

import com.namchok.data.model.GetPopularMoviesResponse
import com.namchok.data.model.MoviesListType
import com.namchok.data.service.HomeApiInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

interface HomeApiRepository {
    fun getPopularMovies(type: MoviesListType): Flow<GetPopularMoviesResponse>
}

class HomeApiRepositoryImpl(
    private val service: HomeApiInterface,
) : HomeApiRepository {
    override fun getPopularMovies(type: MoviesListType): Flow<GetPopularMoviesResponse> =
        flow {
            val response =
                when (type) {
                    MoviesListType.POPULAR -> service.getPopularMovies()
                    MoviesListType.TOP_RATE -> service.getTopRateMovies()
                }
            if (response.isSuccessful) {
                response.body()?.let { body ->
                    emit(body)
                } ?: run {
                    throw IllegalStateException("Response body is null")
                }
            } else {
                throw IllegalStateException("Response is failure")
            }
        }
}
