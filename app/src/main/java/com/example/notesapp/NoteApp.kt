package com.example.notesapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notesapp.feature_notes.presentation.navigation.Navigation
import com.example.notesapp.feature_notes.presentation.screen.notescreen.NoteScreenViewModel
import com.example.notesapp.feature_notes.presentation.utils.ThemePreferences
import com.example.notesapp.ui.theme.NoteAppAiTheme

@Composable
fun NoteApp() {
    val context = LocalContext.current
    val persistedDarkMode = ThemePreferences.darkModeFlow(context).collectAsState(initial = false)
    val isDarkMode = rememberSaveable { mutableStateOf(false) }
    LaunchedEffect(persistedDarkMode.value) {
        isDarkMode.value = persistedDarkMode.value
    }
    val viewModel: NoteScreenViewModel = hiltViewModel()

    NoteAppAiTheme (darkTheme = isDarkMode.value){
        Navigation(viewModel = viewModel, isDarkMode = isDarkMode)
    }

}