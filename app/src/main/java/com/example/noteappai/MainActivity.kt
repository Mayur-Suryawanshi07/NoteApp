package com.example.noteappai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.noteappai.presentation.Screen.EditScreen.AddNoteScreen
import com.example.noteappai.presentation.Screen.EditScreen.NoteDetailScreen
import com.example.noteappai.presentation.Screen.NoteScreen.NoteApp
import com.example.noteappai.presentation.Screen.NoteScreen.NoteScreenViewModel
import com.example.noteappai.presentation.Screen.NoteScreen.NotesListScreen
import com.example.noteappai.presentation.navigation.NoteAppState
import com.example.noteappai.presentation.navigation.Screen
import com.example.noteappai.ui.theme.NoteAppAiTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModel: NoteScreenViewModel = hiltViewModel()
            NoteAppAiTheme {
                NoteApp(viewModel)
            }
        }
    }
}
