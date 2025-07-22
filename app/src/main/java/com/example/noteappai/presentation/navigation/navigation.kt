package com.example.noteappai.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteappai.domain.model.Note
import com.example.noteappai.presentation.Screen.EditScreen.AddNoteScreen
import com.example.noteappai.presentation.Screen.NoteScreen.NoteScreenViewModel
import com.example.noteappai.presentation.Screen.NoteScreen.NotesListScreen
import com.example.noteappai.presentation.utils.ColorPalette


@Composable
fun NoteApp(modifier: Modifier = Modifier, viewModel: NoteScreenViewModel) {

    val navController = rememberNavController()
    val state by viewModel.notesState.collectAsState()

    NavHost(navController = navController, startDestination = Routes.NoteScreen.route) {
        composable(route = Routes.NoteScreen.route) {
            NotesListScreen(
                notes = state.notes,
                onAddNote = {
                    navController.navigate(Routes.EditNoteScreen.passArg(-1))
                },
                onEditNote = { noteId ->
                    navController.navigate(Routes.EditNoteScreen.passArg(state.notes.find { it.id == noteId }?.id ?: -1))
                },
                onDeleteNote = {
                    note -> viewModel.deleteNote(note)
                }
            )
        }
        composable(
            route = Routes.EditNoteScreen.route,
            arguments = listOf(navArgument("noteId") {
                type = NavType.IntType
                defaultValue = -1
            })
        ) {
            val noteId = it.arguments?.getInt("noteId")?: -1

            AddNoteScreen(
                noteID = noteId,
                onBackPressed = { navController.popBackStack() },
                navigation = navController,
            )
        }

    }


}