package com.example.notesapp.feature_notes.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notesapp.feature_notes.presentation.screen.editnotes.EditNotesScreen
import com.example.notesapp.feature_notes.presentation.screen.notedetail.NoteDetailScreen
import com.example.notesapp.feature_notes.presentation.screen.notescreen.NoteScreen
import com.example.notesapp.feature_notes.presentation.screen.notescreen.NoteScreenViewModel


@Composable
fun Navigation(viewModel: NoteScreenViewModel, isDarkMode: MutableState<Boolean>) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.NoteScreen.route) {
        //Note Screen
        composable(route = Routes.NoteScreen.route) {
            NoteScreen(
                navigation = navController,
                viewModel = viewModel,
                isDarkmode = isDarkMode

            )
        }

        //Edit Note Screen
        composable(
            route = Routes.EditNoteScreen.route,
            arguments = listOf(navArgument("noteId") {
                type = NavType.IntType
                defaultValue = -1
            })
        ) {
            val noteId = it.arguments?.getInt("noteId")?: -1

            EditNotesScreen(
                noteID = noteId,
                navigation = navController,
            )
        }

        //Note Detail Screen
        composable(route = Routes.NoteDetailScreen.route,
            arguments = listOf(
                navArgument("noteId"){
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
            ){
            NoteDetailScreen(
                navigation = navController
            )
        }
    }
}