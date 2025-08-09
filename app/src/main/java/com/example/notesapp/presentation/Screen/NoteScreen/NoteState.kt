package com.example.notesapp.presentation.Screen.NoteScreen

import com.example.notesapp.domain.model.Note

data class NoteState (
    val notes: List<Note> = emptyList(),
    )