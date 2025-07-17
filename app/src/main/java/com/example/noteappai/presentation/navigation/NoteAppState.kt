package com.example.noteappai.presentation.navigation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.example.noteappai.presentation.utils.ColorPalette
import com.example.noteappai.domain.model.Note

//sealed class Screen {
//    object NotesList : Screen()
//    object AddNote : Screen()
//    data class NoteDetail(val note: Note) : Screen()
//}
//
//class NoteAppState {
//
//
//    var notes by mutableStateOf<List<Note>>(
//        listOf(
//            Note(
//                title = "Welcome to NoteApp!",
//                content = "This is your first note. Tap the + button to create more notes with different colors!",
//                color = ColorPalette.colors[1]
//            ),
//            Note(
//                title = "Shopping List",
//                content = "• Milk\n• Bread\n• Eggs\n• Bananas\n• Coffee",
//                color = ColorPalette.colors[3]
//            ),
//            Note(
//                title = "Meeting Notes",
//                content = "Team meeting scheduled for tomorrow at 2 PM. Don't forget to prepare the quarterly report presentation.",
//                color = ColorPalette.colors[5]
//            ),
//            Note(
//                title = "Ideas",
//                content = "Great app ideas:\n1. Recipe manager\n2. Fitness tracker\n3. Budget planner\n4. Travel journal",
//                color = ColorPalette.colors[7]
//            )
//        )
//    )
//        private set
//
////    fun navigateTo(screen: Screen) {
////        currentScreen = screen
////    }
//
//    fun addNote(note: Note) {
//        notes = notes + note
//        navigateTo(Screen.NotesList)
//    }
//
//    fun deleteNote(noteId: String) {
//        notes = notes.filter { it.id != noteId }
//    }
//
//    fun getNoteById(noteId: String): Note? {
//        return notes.find { it.id == noteId }
//    }
//}