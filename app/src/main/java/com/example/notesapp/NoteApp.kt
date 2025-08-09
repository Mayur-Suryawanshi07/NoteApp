package com.example.notesapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notesapp.presentation.navigation.Navigation
import com.example.notesapp.presentation.screen.notescreen.NoteScreenViewModel
import com.example.notesapp.ui.theme.NoteAppAiTheme

@Composable
fun NoteApp() {

    val isDarkMode= rememberSaveable{
        mutableStateOf(false)
    }
    val viewModel: NoteScreenViewModel = hiltViewModel()

    NoteAppAiTheme (darkTheme = isDarkMode.value){
        Navigation(viewModel = viewModel, isDarkMode = isDarkMode)
    }

}