package com.example.notesapp.presentation.screen.notescreen

import com.example.notesapp.domain.model.Note

data class NoteScreenUiState (
    val notes: List<Note> = emptyList(),
    val note :Note?=null
    )