package com.example.noteappai.domain.use_cases

import com.example.noteappai.domain.model.Note
import com.example.noteappai.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetNotesUseCase @Inject constructor(
    private val repository: NoteRepository
) {

    operator fun invoke() : Flow<List<Note>>{
        return repository.getNotes()

    }
}