package com.example.notesapp.domain.model

import androidx.compose.ui.graphics.Color
import java.time.LocalDateTime

data class Note(
    val id: Int?= null,
    val title: String,
    val content: String,
    val color: Color,
    val timestamp: LocalDateTime = LocalDateTime.now()
)