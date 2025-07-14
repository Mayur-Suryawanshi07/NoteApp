package com.example.noteappai.domain.model

import androidx.compose.ui.graphics.Color
import java.time.LocalDateTime
import java.util.UUID

data class Note(
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val content: String,
    val color: Color,
    val timestamp: LocalDateTime = LocalDateTime.now()
)