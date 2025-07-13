package com.knighttech.pocketlibrary.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


val md_theme_light_primary       = Color(0xFF335E8C)
val md_theme_light_onPrimary     = Color(0xFFFFFFFF)
val md_theme_light_secondary     = Color(0xFF6BAF69)
val md_theme_light_onSecondary   = Color(0xFFFFFFFF)
val md_theme_light_tertiary      = Color(0xFFC74E48)
val md_theme_light_onTertiary    = Color(0xFFFFFFFF)
val md_theme_light_background    = Color(0xFFFDFDFD)
val md_theme_light_onBackground  = Color(0xFF1C1B1F)
val md_theme_light_surface       = Color(0xFFFFFFFF)
val md_theme_light_onSurface     = Color(0xFF1C1B1F)

val md_theme_dark_primary        = Color(0xFFA9C0E6)
val md_theme_dark_onPrimary      = Color(0xFF00315A)
val md_theme_dark_secondary      = Color(0xFFAEE4AB)
val md_theme_dark_onSecondary    = Color(0xFF1B3619)
val md_theme_dark_tertiary       = Color(0xFFFFB4A9)
val md_theme_dark_onTertiary     = Color(0xFF60100B)
val md_theme_dark_background     = Color(0xFF1C1B1F)
val md_theme_dark_onBackground   = Color(0xFFE6E1E5)
val md_theme_dark_surface        = Color(0xFF1C1B1F)
val md_theme_dark_onSurface      = Color(0xFFE6E1E5)



@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = Color(0xFFA9C0E6),
            secondary = Color(0xFFAEE4AB),
            tertiary = Color(0xFFFFB4A9)
        )
    } else {
        lightColorScheme(
            primary = Color(0xFF335E8C),
            secondary = Color(0xFF6BAF69),
            tertiary = Color(0xFFC74E48)
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
