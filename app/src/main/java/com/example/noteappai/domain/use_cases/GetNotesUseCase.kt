package com.example.noteappai.domain.use_cases

import com.example.noteappai.data.local.NoteDto
import com.example.noteappai.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class GetNotesUseCase(
    private val repository: NoteRepository
) {

    operator fun invoke() : Flow<List<NoteDto>>{
        return repository.getNotes()

    }
}