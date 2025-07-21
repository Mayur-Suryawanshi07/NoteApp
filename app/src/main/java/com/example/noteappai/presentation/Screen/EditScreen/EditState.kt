package com.example.noteappai.presentation.Screen.EditScreen

import androidx.compose.ui.graphics.Color



data class EditScreenUiState(
   val noteId: Int? = null,
   val title: String = "",
   val content: String = "",
   val color: Color = Color(0xFFFFFFFF),
   val isLoading: Boolean = false,
   val isSaved: Boolean = false,
   val error: String? = null
)