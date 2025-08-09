package com.example.notesapp.presentation.Screen.EditNoteScreen

import androidx.compose.ui.graphics.Color
import com.example.notesapp.presentation.utils.ColorPalette


data class EditScreenUiState(
   val noteId: Int? = null,
   val title: String = "",
   val content: String = "",
   var color: Color = ColorPalette.getRandomColor(),
   val isLoading: Boolean = false,
   val isSaved: Boolean = false,
   val error: String? = null
)