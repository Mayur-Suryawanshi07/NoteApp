package com.example.noteappai.presentation.navigation


sealed class Routes(val route: String) {
    object NoteScreen : Routes("note_screen")
    object EditNoteScreen : Routes("edit_note_screen/{noteId}"){
        fun passArg(noteId: Int): String {
            return "edit_note_screen/$noteId"
        }
    }


}