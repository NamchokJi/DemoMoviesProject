package com.namchok.resource

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.remember

object AppTheme {
    val colors: AppColors
        @Composable
        @ReadOnlyComposable
        get() = LocalColors.current

    val dimensions: AppDimensions
        @Composable
        @ReadOnlyComposable
        get() = LocalDimensions.current
}

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val colors = lightColors()
    BaseTheme(
        colors = colors,
        content = content,
    )
}

@Composable
fun BaseTheme(
    colors: AppColors = AppTheme.colors,
    dimensions: AppDimensions = AppTheme.dimensions,
    content: @Composable () -> Unit,
) {
    val rememberedColors = remember { colors.copy() }.apply { updateColorsFrom(colors) }
    CompositionLocalProvider(
        LocalColors provides rememberedColors,
        LocalDimensions provides dimensions,
    ) {
        MaterialTheme(
            colorScheme = colors.toColorScheme(),
            content = content,
        )
    }
}
