package com.example.noteappai.domain.use_cases

import com.example.noteappai.data.local.NoteDto
import com.example.noteappai.domain.repository.NoteRepository

class InsertNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: NoteDto) {
        return repository.insertNote(note)
    }

}