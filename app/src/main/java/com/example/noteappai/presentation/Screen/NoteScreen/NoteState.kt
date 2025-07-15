package com.example.noteappai.presentation.Screen.NoteScreen

import com.example.noteappai.domain.model.Note

data class NoteState (
    val notes: List<Note> = emptyList(),
    )