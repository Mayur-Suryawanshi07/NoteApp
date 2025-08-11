package com.example.notesapp.feature_notes.presentation.screen.notedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.feature_notes.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val useCases: NoteUseCases,
    savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = MutableStateFlow(NoteDetailUiState())
    val state: StateFlow<NoteDetailUiState> = _state.asStateFlow()

    init {
        val noteId = savedStateHandle.get<Int>("noteId") ?: -1
        if (noteId != -1) {
            loadNoteById(noteId)
        }
    }


    fun loadNoteById(noteId:Int){
        viewModelScope.launch {
            val note=useCases.getNoteId(noteId)
            _state.value=state.value.copy(note = note)
        }
    }



}