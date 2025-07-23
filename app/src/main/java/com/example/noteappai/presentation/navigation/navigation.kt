package com.example.noteappai.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.noteappai.presentation.Screen.EditNoteScreen.AddNoteScreen
import com.example.noteappai.presentation.Screen.NoteDetailScreen.NoteDetailScreen
import com.example.noteappai.presentation.Screen.NoteScreen.NoteScreenViewModel
import com.example.noteappai.presentation.Screen.NoteScreen.NotesListScreen


@Composable
fun NoteApp( viewModel: NoteScreenViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.NoteScreen.route) {
        //Note Screen
        composable(route = Routes.NoteScreen.route) {
            NotesListScreen(
                navigation = navController,
                viewModel = viewModel
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
                onBackPressed = { navController.popBackStack() },
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
            NoteDetailScreen(onBackPressed = { navController.popBackStack() })
        }
    }
}