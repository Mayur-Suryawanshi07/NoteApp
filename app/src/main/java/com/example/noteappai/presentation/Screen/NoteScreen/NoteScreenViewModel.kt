package com.example.noteappai.presentation.Screen.NoteScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteappai.domain.model.Note
import com.example.noteappai.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteScreenViewModel @Inject constructor(
    private val noteUseCases: NoteUseCases
): ViewModel() {

    private val _notes = MutableStateFlow(NoteState())
    val notes: StateFlow<NoteState> = _notes.asStateFlow()

    fun getNotes(note: Note) {
        viewModelScope.launch {
            noteUseCases.GetNotes.invoke()
        }
    }




}