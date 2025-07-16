package com.example.noteappai.presentation.Screen.NoteScreen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import com.example.noteappai.domain.model.Note
import com.example.noteappai.presentation.Screen.EditScreen.AddNoteScreen
import com.example.noteappai.presentation.Screen.EditScreen.NoteDetailScreen
import com.example.noteappai.presentation.navigation.NoteAppState
import com.example.noteappai.presentation.navigation.Screen

@Composable
fun NoteApp(viewModel: NoteScreenViewModel) {
    val appState = remember { NoteAppState() }



    when (val screen = appState.currentScreen) {
        is Screen.NotesList -> {
            NotesListScreen(
                notes = appState.notes,
                onAddNote = { appState.navigateTo(Screen.AddNote) },
                onNoteClick = {
                        note -> appState.navigateTo(Screen.NoteDetail(note))
                },
                viewModel = viewModel
            )
        }
        is Screen.AddNote -> {
            AddNoteScreen(
                onBackPressed = { appState.navigateTo(Screen.NotesList) },
                onNoteSaved = { note -> appState.addNote(note) },
                viewModel = viewModel,
            )
        }
        is Screen.NoteDetail -> {
            NoteDetailScreen(
                note = screen.note,
                onBackPressed = { appState.navigateTo(Screen.NotesList) }
            )
        }
    }
}