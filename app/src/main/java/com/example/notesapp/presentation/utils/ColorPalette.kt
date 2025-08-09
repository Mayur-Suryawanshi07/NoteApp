package com.example.notesapp.presentation.utils

import androidx.compose.ui.graphics.Color

object ColorPalette {
    val colors = listOf(
        Color(0xFFFFE0B2), // Light Orange
        Color(0xFFE1F5FE), // Light Blue
        Color(0xFFF3E5F5), // Light Purple
        Color(0xFFE8F5E8), // Light Green
        Color(0xFFFFEBEE), // Light Red
        Color(0xFFFCE4EC), // Light Pink
        Color(0xFFF1F8E9), // Light Lime
        Color(0xFFE0F2F1), // Light Teal
        Color(0xFFFFF3E0), // Light Amber
        Color(0xFFE8EAF6), // Light Indigo
        Color(0xFFE0F7FA)  // Light Cyan
    )

    fun getRandomColor(): Color = colors.random()
}