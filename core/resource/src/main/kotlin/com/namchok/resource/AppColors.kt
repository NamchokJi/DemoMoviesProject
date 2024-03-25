package com.namchok.resource

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

private val colorWhite = Color(0xFFFFFFFF)
private val colorBlack = Color(0xFF000000)
private val colorPrimaryGrey = Color(0xFF1F1F1F)

class AppColors(
    white: Color,
    black: Color,
    primaryGrey: Color,
) {
    var white by mutableStateOf(white)
        internal set
    var black by mutableStateOf(black)
        internal set
    var primaryGrey by mutableStateOf(black)
        internal set

    fun copy(
        white: Color = this.white,
        black: Color = this.black,
        primaryGrey: Color = this.primaryGrey,
    ): AppColors =
        AppColors(
            white,
            black,
            primaryGrey,
        )

    fun updateColorsFrom(other: AppColors) {
        white = other.white
        black = other.black
        primaryGrey = other.primaryGrey
    }

    fun toColorScheme(): ColorScheme {
        return lightColorScheme()
    }
}

fun lightColors(
    white: Color = colorWhite,
    black: Color = colorBlack,
    primaryGrey: Color = colorPrimaryGrey,
): AppColors =
    AppColors(
        white = white,
        black = black,
        primaryGrey = primaryGrey,
    )

internal val LocalColors = staticCompositionLocalOf { lightColors() }
