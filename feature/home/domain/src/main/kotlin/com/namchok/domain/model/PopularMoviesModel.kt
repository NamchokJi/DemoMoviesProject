package com.namchok.domain.model

data class MoviesDetailModel(
    val id: Int = 0,
    val backdrop: String = "",
    val title: String = "",
    val overview: String = "",
    val poster: String = "",
    val voteAverage: Double = 0.0,
)
