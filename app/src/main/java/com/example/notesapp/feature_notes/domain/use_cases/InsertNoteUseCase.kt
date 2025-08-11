package com.example.notesapp.feature_notes.domain.use_cases

import com.example.notesapp.feature_notes.domain.model.Note
import com.example.notesapp.feature_notes.domain.repository.NoteRepository
import javax.inject.Inject

class InsertNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        return repository.insertNote(note)
    }

}