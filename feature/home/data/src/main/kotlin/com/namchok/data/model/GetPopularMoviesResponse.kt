package com.namchok.data.model

import com.google.gson.annotations.SerializedName

data class GetPopularMoviesResponse(
    @SerializedName("page")
    val page: Int?,
    @SerializedName("results")
    val results: List<MovieDetailResponse>?,
)

data class MovieDetailResponse(
    @SerializedName("backdrop_path")
    val backdrop: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("poster_path")
    val poster: String?,
    @SerializedName("vote_average")
    val voteAverage: Double?,
)
