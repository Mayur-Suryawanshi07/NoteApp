package com.example.noteappai.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Navigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost (navController = navController, startDestination = Routes.NoteScreen.route){
        composable(route = Routes.NoteScreen.route){


        }
        composable(route = Routes.EditNoteScreen.route){

        }


    }

}