package com.namchok.domain.usecase

import com.namchok.data.model.MoviesListType
import com.namchok.domain.model.HomeModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class GetHomeMoviesUseCase(
    private val useCase: MappingPopularMoviesUseCase,
) {
    fun execute(): Flow<HomeModel> =
        useCase.execute(MoviesListType.POPULAR).combine(
            useCase.execute(MoviesListType.TOP_RATE),
        ) { popular, toprate ->
            HomeModel(
                popularMovies = popular,
                topRatedMovies = toprate,
            )
        }
}
