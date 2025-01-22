package com.plcoding.bluelink.ui.theme

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf

private val DarkColors = darkColors(
    primary = DarkPrimary,
    secondary = stripDark,
    background = DarkBackground,
    surface = borderDark,
    onPrimary = DarkText,
    onSecondary = DarkSecondary,
    onBackground = buttond,
    //onSurface = DarkText
)

private val LightColors = lightColors(
    primary = LightPrimary,
    secondary = stripLight,
    background = LightBackground,
    surface = borderLight,
    onPrimary = LightText,
    onSecondary = LightSecondary,
    onBackground = buttonl,
    onSurface = LightText,
)

object ThemeState {
    val isDarkTheme = mutableStateOf(true) // Manage theme state globally
}

@Composable
fun BluetoothChatTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = if (ThemeState.isDarkTheme.value) DarkColors else LightColors,
        content = content
    )
}
