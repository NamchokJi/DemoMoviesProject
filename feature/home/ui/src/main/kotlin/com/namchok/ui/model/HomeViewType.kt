package com.namchok.ui.model

import com.namchok.domain.model.MoviesDetailModel

sealed class HomeViewType(
    open val moviesList: MutableList<MoviesDetailModel> = mutableListOf(),
) {
    data class PopularMovies(
        override val moviesList: MutableList<MoviesDetailModel> = mutableListOf(),
    ) : HomeViewType(moviesList)

    data class TopRatedMovies(
        override val moviesList: MutableList<MoviesDetailModel> = mutableListOf(),
    ) : HomeViewType(moviesList)
}
