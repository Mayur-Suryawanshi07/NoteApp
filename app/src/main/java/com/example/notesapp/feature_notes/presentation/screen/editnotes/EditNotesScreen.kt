package com.example.notesapp.feature_notes.presentation.screen.editnotes

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.focus.FocusRequester
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notesapp.feature_notes.presentation.navigation.Routes
import com.example.notesapp.feature_notes.presentation.screen.components.NotesTopAppBar
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNotesScreen(
    noteID: Int,
    navigation: NavHostController,
    edtViewModel: EditNotesViewModel = hiltViewModel()
) {

    val state by edtViewModel.uiState.collectAsState()

    val titleFocusRequester = remember { FocusRequester() }
    val contentFocusRequester = remember { FocusRequester() }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            NotesTopAppBar(
                title = "Notes",
                subTitle = "Add or Edit Notes"
                ,
                showNavigationIcon = true,

                backNavigationIcon = {
                    navigation.popBackStack()
                },
                action = {
                    IconButton(
                        onClick = {
                            navigation.navigate(Routes.NoteDetailScreen.passArgDetail(state.noteId?:-1))
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = "info about notes")
                    }
                    IconButton(
                        onClick = {
                            edtViewModel.saveNote()
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Check, contentDescription = "Save Note")
                    }

                }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->

        EditNotesBody(padding, state ,edtViewModel,titleFocusRequester,contentFocusRequester)

    }

    LaunchedEffect(Unit) {
        titleFocusRequester.requestFocus()
    }
    LaunchedEffect(state.isSaved) {
        if (state.isSaved) {
            navigation.popBackStack() // or navigate back to list screen
        }
    }
    LaunchedEffect(noteID) {
        edtViewModel.loadNote(noteID)
    }

    LaunchedEffect(state.error) {
        state.error?.let { message ->
            scope.launch {
                snackbarHostState.showSnackbar(message)
                edtViewModel.clearError()
            }
        }
    }

}
