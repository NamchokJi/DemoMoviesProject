package com.namchok.resource

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class AppDimensions(
    val paddingS: Dp = 4.dp,
    val paddingM: Dp = 8.dp,
    val paddingL: Dp = 16.dp,
    val paddingXL: Dp = 24.dp,
    val paddingXXL: Dp = 32.dp,
)

internal val LocalDimensions = staticCompositionLocalOf { AppDimensions() }
