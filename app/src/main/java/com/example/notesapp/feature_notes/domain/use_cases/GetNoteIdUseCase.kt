package com.example.notesapp.feature_notes.domain.use_cases

import com.example.notesapp.feature_notes.domain.repository.NoteRepository
import javax.inject.Inject

class GetNoteIdUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int) = repository.getNoteById(id)
}