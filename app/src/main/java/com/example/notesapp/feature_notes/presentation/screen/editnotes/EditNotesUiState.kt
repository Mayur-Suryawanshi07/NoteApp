package com.example.notesapp.feature_notes.presentation.screen.editnotes

import com.example.notesapp.feature_notes.presentation.utils.ColorPalette
import androidx.compose.ui.graphics.toArgb

data class EditNotesUiState(
   val noteId: Int? = null,
   val title: String = "",
   val content: String = "",
   var color: Int = ColorPalette.getRandomColor().toArgb(),
   val isLoading: Boolean = false,
   val isSaved: Boolean = false,
   val error: String? = null,

)