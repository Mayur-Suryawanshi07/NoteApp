package com.example.noteappai.presentation.Screen.EditScreen


import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappai.domain.use_cases.NoteUseCases
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel


@HiltViewModel
class EditScreenViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
): ViewModel(){

    private val _uiState = MutableStateFlow(EditScreenUiState())
    val uiState: StateFlow<EditScreenUiState> = _uiState.asStateFlow()

    fun loadNote(noteId: Int?) {
        if (noteId == null || noteId == -1) return
        _uiState.value = _uiState.value.copy(isLoading = true)
        viewModelScope.launch {
            val note = noteUseCases.GetNoteId.invoke(noteId)
            if (note != null) {
                _uiState.value = _uiState.value.copy(
                    noteId = note.id,
                    title = note.title,
                    content = note.content,
                    color = note.color,
                    isLoading = false
                )
            } else {
                _uiState.value = _uiState.value.copy(isLoading = false, error = "Note not found")
            }
        }
    }

    fun onTitleChange(newTitle: String) {
        _uiState.value = _uiState.value.copy(title = newTitle)
    }

    fun onContentChange(newContent: String) {
        _uiState.value = _uiState.value.copy(content = newContent)
    }

    fun onColorChange(newColor: Color) {
        _uiState.value = _uiState.value.copy(color = newColor)
    }

    fun saveNote() {
        val state = _uiState.value
        if (state.title.isBlank() || state.content.isBlank()) {
            _uiState.value = state.copy(error = "Note can't be empty!")
            return
        }
        viewModelScope.launch {
            noteUseCases.AddNote.invoke(
                com.example.noteappai.domain.model.Note(
                    id = if (state.noteId == null || state.noteId == -1) null else state.noteId,
                    title = state.title,
                    content = state.content,
                    color = state.color
                )
            )
            _uiState.value = _uiState.value.copy(isSaved = true)
        }
    }

    fun clearError() {
        _uiState.value = _uiState.value.copy(error = null)
    }
}