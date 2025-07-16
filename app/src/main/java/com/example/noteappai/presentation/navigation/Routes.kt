package com.example.noteappai.presentation.navigation


sealed class Routes(val route: String) {
    object NoteScreen : Routes("note_screen")
    object EditNoteScreen : Routes("edit_note_screen")
}