package com.example.notesapp.domain.use_cases

import com.example.notesapp.domain.repository.NoteRepository
import javax.inject.Inject

class GetNoteIdUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(id: Int) = repository.getNoteById(id)
}