package com.example.notesapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notesapp.presentation.Screen.EditNoteScreen.AddNoteScreen
import com.example.notesapp.presentation.Screen.NoteDetailScreen.NoteDetailScreen
import com.example.notesapp.presentation.Screen.NoteScreen.NoteScreenViewModel
import com.example.notesapp.presentation.Screen.NoteScreen.NotesListScreen


@Composable
fun NoteApp( viewModel: NoteScreenViewModel,isDarkMode: MutableState<Boolean>) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.NoteScreen.route) {
        //Note Screen
        composable(route = Routes.NoteScreen.route) {
            NotesListScreen(
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

            AddNoteScreen(
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