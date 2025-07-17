package com.example.noteappai

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.noteappai.presentation.Screen.NoteScreen.NoteScreenViewModel
import com.example.noteappai.presentation.navigation.NoteApp
import com.example.noteappai.ui.theme.NoteAppAiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val viewModel: NoteScreenViewModel = hiltViewModel()
            NoteAppAiTheme {
                NoteApp(viewModel = viewModel)
            }
        }
    }
}
