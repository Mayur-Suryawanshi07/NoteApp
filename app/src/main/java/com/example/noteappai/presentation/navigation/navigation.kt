package com.example.noteappai.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.noteappai.domain.model.Note
import com.example.noteappai.presentation.Screen.EditScreen.AddNoteScreen
import com.example.noteappai.presentation.Screen.NoteScreen.NoteScreenViewModel
import com.example.noteappai.presentation.Screen.NoteScreen.NotesListScreen
import com.example.noteappai.presentation.utils.ColorPalette


@Composable
fun NoteApp(modifier: Modifier = Modifier,viewModel: NoteScreenViewModel) {

    val navController = rememberNavController()
    val state by viewModel.notesState.collectAsState()

    NavHost (navController = navController, startDestination = Routes.NoteScreen.route){
        composable(route = Routes.NoteScreen.route){
            NotesListScreen(viewModel = viewModel, navController = navController,notes = state.notes)

        }
        composable(route = Routes.EditNoteScreen.route) {
            AddNoteScreen(
                note = Note(title = "", content = "", color = ColorPalette.colors[0]),
                onBackPressed = { navController.popBackStack() },
                onNoteSaved = { note ->
                    viewModel.addNote(note)
                    navController.popBackStack()
                }
            )
        }


    }

}