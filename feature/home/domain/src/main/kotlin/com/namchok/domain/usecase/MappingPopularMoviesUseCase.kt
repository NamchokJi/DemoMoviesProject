package com.namchok.domain.usecase

import com.namchok.data.model.MovieDetailResponse
import com.namchok.data.model.MoviesListType
import com.namchok.data.repository.HomeApiRepository
import com.namchok.domain.model.MoviesDetailModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.flowOf

class MappingPopularMoviesUseCase(
    private val repository: HomeApiRepository,
) {
    @OptIn(ExperimentalCoroutinesApi::class)
    fun execute(type: MoviesListType): Flow<MutableList<MoviesDetailModel>> =
        repository.getPopularMovies(type).flatMapMerge { response ->
            flowOf(mappingPopularMovies(response.results.orEmpty()))
        }

    private fun mappingPopularMovies(response: List<MovieDetailResponse>): MutableList<MoviesDetailModel> {
        return response
            .map { movie ->
                MoviesDetailModel(
                    id = movie.id ?: 0,
                    title = movie.title.orEmpty(),
                    overview = movie.overview.orEmpty(),
                    backdrop = movie.backdrop.orEmpty(),
                    poster = "https://image.tmdb.org/t/p/w500${movie.poster.orEmpty()}",
                    voteAverage = movie.voteAverage ?: 0.0,
                )
            }.toMutableList()
    }
}
