package com.example.noteappai.presentation.Screen.EditScreen

import androidx.compose.ui.graphics.Color
import com.example.noteappai.domain.model.Note
import com.example.noteappai.presentation.utils.ColorPalette


data class EditScreenUiState(
   val noteId: Int? = null,
   val title: String = "",
   val content: String = "",
   var color: Color = ColorPalette.getRandomColor(),
   val isLoading: Boolean = false,
   val isSaved: Boolean = false,
   val error: String? = null
)