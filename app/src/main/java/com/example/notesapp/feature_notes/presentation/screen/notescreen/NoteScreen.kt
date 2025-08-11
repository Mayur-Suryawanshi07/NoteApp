package com.example.notesapp.feature_notes.presentation.screen.notescreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notesapp.R
import com.example.notesapp.feature_notes.presentation.navigation.Routes
import com.example.notesapp.feature_notes.presentation.screen.components.NotesTopAppBar
import com.example.notesapp.feature_notes.presentation.utils.ThemePreferences
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun NoteScreen(
    navigation: NavHostController,
    viewModel: NoteScreenViewModel = hiltViewModel(),
    isDarkmode : MutableState<Boolean>
) {
    val state by viewModel.notesState.collectAsState()
    val scrollBehavior= TopAppBarDefaults.pinnedScrollBehavior()
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

     Scaffold(
         //to connect the scroll behaviour to the scaffold or to the lazyContent
         modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
         topBar = {
            NotesTopAppBar(
                title = "My notes",
                subTitle = "Create Your Notes",
                scrollBehaviour =scrollBehavior,
                action = {
                    IconButton(
                        onClick = {
                            val newValue = !isDarkmode.value
                            isDarkmode.value = newValue
                            scope.launch { ThemePreferences.setDarkMode(context, newValue) }
                        }
                    ) {
                        Icon(painter =
                           if (isDarkmode.value) painterResource(R.drawable.ic_sunnyflled)
                           else painterResource(R.drawable.ic_darkmode),
                            contentDescription = "DarkMode")
                    }
                }
            )
        },
         floatingActionButton = {
            FloatingActionButton(
                onClick = {
                   navigation.navigate(Routes.EditNoteScreen.passArg(-1))
                },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = "Add Note",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    ) { padding ->
        if (state.notes.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Text(
                        text = "No Notes Yet",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Medium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                    Text(
                        text = "Tap the + button to create your first note",
                        fontSize = 14.sp,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                    )
                }
            }
        } else {
            LazyVerticalStaggeredGrid(
                columns = StaggeredGridCells.Adaptive(minSize = 160.dp),
                contentPadding = PaddingValues(12.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalItemSpacing = 6.dp,
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                items(state.notes) { note ->
                    NoteScreenCard(
                        note = note,
                        onClick = {
                            navigation.navigate(Routes.EditNoteScreen.passArg(note.id ?: -1))
                        },
                        onDelete = {
                            viewModel.deleteNote(note)
                        }
                    )
                }
            }
        }
    }
}
