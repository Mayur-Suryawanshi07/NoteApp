package com.example.notesapp.presentation.screen.notescreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteScreenViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
) : ViewModel() {

    private val _notesState = MutableStateFlow(NoteScreenUiState())
    val notesState: StateFlow<NoteScreenUiState> =
        _notesState.asStateFlow() //Read-only (can only observe the value, not change it)

    init {
        getNotes()
    }


    fun getNotes() {
        viewModelScope.launch {

            noteUseCases.getNotes.invoke()
                .map { NoteScreenUiState(it) }
                .collect {
                    _notesState.value = it
                }
        }
    }

    fun setSelectedNote(note: Note) {
        _notesState.value = _notesState.value.copy(note = note)
    }


    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteUseCases.deleteNote.invoke(note)
        }
    }


}