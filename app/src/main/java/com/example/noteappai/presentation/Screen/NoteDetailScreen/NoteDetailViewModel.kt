package com.example.noteappai.presentation.Screen.NoteDetailScreen

import androidx.lifecycle.ViewModel
import com.example.noteappai.domain.use_cases.NoteUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class NoteDetailViewModel @Inject constructor(
    private val useCases: NoteUseCases,
): ViewModel() {

    private val _state = MutableStateFlow(NotesDetailState())
    val state: StateFlow<NotesDetailState> = _state.asStateFlow()


    fun showDetail(noteId: Int) {


    }



}