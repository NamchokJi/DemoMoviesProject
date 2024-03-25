package com.namchok.core.common.base

import android.content.Intent

data class BaseUiState<T>(
    val isLoading: Boolean = false,
    val message: String? = null,
    val errorMessage: String? = null,
    val mainUiState: T? = null,
    val popBackStackTo: String? = null,
    val openBottomSheet: Boolean = false,
    val openIntent: Intent? = null,
    val snackbarTitle: String? = null,
    val snackbarSubtitle: String? = null,
    val isSnackbarError: Boolean = false,
    val isCloseApp: Boolean = false,
    val isApiError: Boolean = false,
    val isCloseBottomSheet: Boolean = false,
)
