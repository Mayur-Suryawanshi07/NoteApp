package com.example.notesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notesapp.presentation.Screen.NoteScreen.NoteScreenViewModel
import com.example.notesapp.presentation.navigation.NoteApp
import com.example.notesapp.ui.theme.NoteAppAiTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val isDarkMode= rememberSaveable{
                mutableStateOf(false)
            }

            val viewModel: NoteScreenViewModel = hiltViewModel()
            NoteAppAiTheme (darkTheme = isDarkMode.value){
                NoteApp(viewModel = viewModel, isDarkMode = isDarkMode)
            }
        }
    }
}
