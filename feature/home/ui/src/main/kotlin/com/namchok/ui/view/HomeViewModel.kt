package com.namchok.ui.view

import androidx.lifecycle.viewModelScope
import com.namchok.core.common.base.BaseViewModel
import com.namchok.domain.model.MoviesDetailModel
import com.namchok.domain.usecase.GetHomeMoviesUseCase
import com.namchok.ui.model.HomeViewType
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update

data class HomeUiState(
    val moviesList: MutableList<MoviesDetailModel> = mutableListOf(),
    val topRateList: MutableList<MoviesDetailModel> = mutableListOf(),
    val viewType: MutableList<HomeViewType> = mutableListOf(),
)

class HomeViewModel(
    private val useCase: GetHomeMoviesUseCase,
) : BaseViewModel<HomeUiState>() {
    init {
        initHomeScreen()
    }

    private fun initHomeScreen() {
        useCase.execute()
            .onStart { setLoading(true) }
            .onEach { result ->
                _uiState.update { currentState ->
                    currentState.copy(
                        mainUiState =
                            HomeUiState(
                                viewType =
                                    mutableListOf(
                                        HomeViewType.PopularMovies(
                                            moviesList = result.popularMovies,
                                        ),
                                        HomeViewType.TopRatedMovies(
                                            moviesList = result.topRatedMovies,
                                        ),
                                    ),
                            ),
                    )
                }
            }
            .catch { setLoading(false) }
            .launchIn(viewModelScope)
    }
}
