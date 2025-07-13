package com.knighttech.pocketlibrary.android.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Theme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        lightColorScheme(
            primary = md_theme_light_primary,
            secondary = md_theme_light_secondary,
            tertiary = md_theme_light_tertiary,
            onPrimary = md_theme_light_onPrimary,
            onSecondary =  md_theme_light_onSecondary,
            onTertiary = md_theme_light_onTertiary,
            background = md_theme_light_background,
            onBackground =  md_theme_light_onBackground,
            surface = md_theme_light_surface,
            onSurface = md_theme_light_onSurface
        )
    } else {
        darkColorScheme(
            primary = md_theme_dark_primary,
            secondary = md_theme_dark_secondary,
            tertiary = md_theme_dark_tertiary,
            onPrimary = md_theme_dark_onPrimary,
            onSecondary =  md_theme_dark_onSecondary,
            onTertiary = md_theme_dark_onTertiary,
            background = md_theme_dark_background,
            onBackground =  md_theme_dark_onBackground,
            surface = md_theme_dark_surface,
            onSurface = md_theme_dark_onSurface
        )
    }
    val typography = Typography(
        bodyMedium = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
    )
    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colorScheme = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}