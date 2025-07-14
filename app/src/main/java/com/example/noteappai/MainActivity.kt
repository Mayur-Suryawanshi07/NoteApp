package com.example.noteappai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.noteappai.presentation.Screen.AddNoteScreen
import com.example.noteappai.presentation.Screen.NoteDetailScreen
import com.example.noteappai.presentation.Screen.NotesListScreen
import com.example.noteappai.presentation.navigation.NoteAppState
import com.example.noteappai.presentation.navigation.Screen
import com.example.noteappai.ui.theme.NoteAppAiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NoteAppAiTheme {
                NoteApp()
            }
        }
    }
}

@Composable
fun NoteApp() {
    val appState = remember { NoteAppState() }
    
    when (val screen = appState.currentScreen) {
        is Screen.NotesList -> {
            NotesListScreen(
                notes = appState.notes,
                onAddNote = { appState.navigateTo(Screen.AddNote) },
                onNoteClick = { note -> appState.navigateTo(Screen.NoteDetail(note)) }
            )
        }
        is Screen.AddNote -> {
            AddNoteScreen(
                onBackPressed = { appState.navigateTo(Screen.NotesList) },
                onNoteSaved = { note -> appState.addNote(note) }
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