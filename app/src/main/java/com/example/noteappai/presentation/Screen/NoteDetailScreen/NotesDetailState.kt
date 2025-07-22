package com.example.noteappai.presentation.Screen.NoteDetailScreen

import androidx.compose.ui.graphics.Color
import com.example.noteappai.presentation.utils.ColorPalette
import java.time.LocalDateTime

data class NotesDetailState(
    val noteId: Int? =null,
    val title: String="",
    val content: String="",
    val color: Color= ColorPalette.getRandomColor(),
    val timestamp: LocalDateTime= LocalDateTime.now()

)
