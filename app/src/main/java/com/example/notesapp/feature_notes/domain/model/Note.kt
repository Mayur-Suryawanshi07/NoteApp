package com.example.notesapp.feature_notes.domain.model

import java.time.LocalDateTime

data class Note(
    val id: Int?= null,
    val title: String,
    val content: String,
    val color: Int, // ARGB Int, UI converts to Color at the boundary
    val timestamp: LocalDateTime = LocalDateTime.now()
)