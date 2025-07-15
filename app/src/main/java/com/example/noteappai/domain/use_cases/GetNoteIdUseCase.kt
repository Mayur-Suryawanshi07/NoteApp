package com.example.noteappai.domain.use_cases

import com.example.noteappai.domain.repository.NoteRepository

class GetNoteIdUseCase(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int) = repository.getNoteById(id)
}