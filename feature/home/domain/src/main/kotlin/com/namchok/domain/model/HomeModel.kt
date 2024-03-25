package com.namchok.domain.model

data class HomeModel(
    val popularMovies: MutableList<MoviesDetailModel> = mutableListOf(),
    val topRatedMovies: MutableList<MoviesDetailModel> = mutableListOf(),
)
