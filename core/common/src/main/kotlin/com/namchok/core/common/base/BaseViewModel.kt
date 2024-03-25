package com.namchok.core.common.base

import android.content.Intent
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

open class BaseViewModel<T> : ViewModel() {
    @Suppress("ktlint:standard:property-naming")
    protected val _uiState = MutableStateFlow(BaseUiState<T>())
    open val uiState: StateFlow<BaseUiState<T>> get() = _uiState.asStateFlow()

    fun popBackStackTo(route: String?) {
        _uiState.update { currentState ->
            currentState.copy(
                popBackStackTo = route,
            )
        }
    }

    fun clearPopBackStackTo() {
        _uiState.update { currentState ->
            currentState.copy(
                popBackStackTo = null,
            )
        }
    }

    fun clearMessage() {
        _uiState.update { currentState ->
            currentState.copy(
                message = null,
            )
        }
    }

    fun clearErrorMessage() {
        _uiState.update { currentState ->
            currentState.copy(
                errorMessage = null,
            )
        }
    }

    fun setLoading(isLoading: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                isLoading = isLoading,
            )
        }
    }

    fun setApiError(isApiError: Boolean) {
        _uiState.update { currentState ->
            currentState.copy(
                isApiError = isApiError,
            )
        }
    }

    fun openIntent(intent: Intent) {
        _uiState.update { currentState ->
            currentState.copy(
                openIntent = intent,
            )
        }
    }

    fun clearOpenIntent() {
        _uiState.update { currentState ->
            currentState.copy(
                openIntent = null,
            )
        }
    }
}
