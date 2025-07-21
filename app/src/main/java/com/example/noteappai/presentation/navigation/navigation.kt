package com.example.noteappai.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteappai.domain.model.Note
import com.example.noteappai.presentation.Screen.EditScreen.AddNoteScreen
import com.example.noteappai.presentation.Screen.EditScreen.EditScreenViewModel
import com.example.noteappai.presentation.Screen.EditScreen.NoteDetailScreen
import com.example.noteappai.presentation.Screen.NoteScreen.NoteScreenViewModel
import com.example.noteappai.presentation.Screen.NoteScreen.NotesListScreen
import com.example.noteappai.presentation.utils.ColorPalette


@Composable
fun NoteApp(modifier: Modifier = Modifier, viewModel: NoteScreenViewModel) {

    val navController = rememberNavController()
    val state by viewModel.notesState.collectAsState()
    val viewModelEdt: NoteScreenViewModel = hiltViewModel()

    NavHost(navController = navController, startDestination = Routes.NoteScreen.route) {
        composable(route = Routes.NoteScreen.route) {
            val state by viewModel.notesState.collectAsState()
            NotesListScreen(
                notes = state.notes,
                onAddNote = { navController.navigate(Routes.EditNoteScreen.passArg(-1)) },
                onEditNote = { noteId -> navController.navigate(Routes.EditNoteScreen.passArg(noteId)) },
                onDeleteNote = { note -> viewModel.deleteNote(note) }
            )
        }
        composable(
            route = Routes.EditNoteScreen.route,
            arguments = listOf(navArgument("noteId") {
                type = NavType.IntType
                defaultValue = -1
            })
        ) {
            val noteId = it.arguments?.getInt("noteId")
            val note = if (noteId == -1) {
                Note(id = null, title = "", content = "", color = ColorPalette.colors[0])
            } else {
                state.notes.find { it.id == noteId }
                    ?: Note(id = noteId, title = "", content = "", color = ColorPalette.colors[0])
            }
            AddNoteScreen(
                note = note,
                onBackPressed = { navController.popBackStack() },
                onNoteSaved = { note ->
                    viewModel.addNote(note)
                    navController.popBackStack()
                }
                ,navigation = navController
            )
        }

        composable(
            route = Routes.NoteDetailScreen.route,
            arguments = listOf(navArgument("noteId") {
                type = NavType.IntType
                defaultValue = -1
            })
        ) {
            val noteId = it.arguments?.getInt("noteId")
            val note = if (noteId == -1) {
                Note(id = null, title = "", content = "", color = ColorPalette.colors[0])
            } else {
                state.notes.find { it.id == noteId }
                    ?: Note(id = noteId, title = "", content = "", color = ColorPalette.colors[0])
            }

            NoteDetailScreen(
                note = note,
                onBackPressed = { navController.popBackStack() }
            )
        }

        }




    }