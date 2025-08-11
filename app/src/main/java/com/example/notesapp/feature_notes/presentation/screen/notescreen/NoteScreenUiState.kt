package com.example.notesapp.feature_notes.presentation.screen.notescreen

import com.example.notesapp.feature_notes.domain.model.Note

data class NoteScreenUiState (
    val notes: List<Note> = emptyList(),
    val note :Note?=null
    )