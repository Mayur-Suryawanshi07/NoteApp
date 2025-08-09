package com.example.notesapp.domain.use_cases

import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import javax.inject.Inject

class InsertNoteUseCase @Inject constructor(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) {
        return repository.insertNote(note)
    }

}