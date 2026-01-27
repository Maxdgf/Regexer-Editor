package com.maxdgf.regexer.ui.utils

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

class CurrentThemeColor {
    @Composable
    fun getAdaptedCurrentThemeColor(
        useAlpha: Boolean,
        alphaFactor: Float = 1f
    ): Color {
        val adaptedColor = if (isSystemInDarkTheme()) Color.Companion.White else Color.Companion.Black
        return if (useAlpha) adaptedColor.copy(alpha = alphaFactor) else adaptedColor
    }
}