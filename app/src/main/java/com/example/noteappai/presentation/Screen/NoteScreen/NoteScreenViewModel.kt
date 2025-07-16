package com.example.noteappai.presentation.Screen.NoteScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappai.domain.model.Note
import com.example.noteappai.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteScreenViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
): ViewModel() {

    private val _notesState = MutableStateFlow(NoteState())
    val notesState: StateFlow<NoteState> = _notesState.asStateFlow() //Read-only (can only observe the value, not change it)

    fun getNotes(note: Note) {
        viewModelScope.launch {

            noteUseCases.GetNotes.invoke()
                .map{ NoteState(it) }
                .stateIn(viewModelScope, SharingStarted.Eagerly,
                NoteState())
        }
    }

    fun getNoteById(Id: Int) {
        viewModelScope.launch {
            noteUseCases.GetNoteId.invoke(Id)
        }
    }


    fun addNote(note: Note) {
        viewModelScope.launch {
            noteUseCases.AddNote.invoke(note)
        }
    }
    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteUseCases.DeleteNote.invoke(note)
        }
    }






}