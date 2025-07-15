package com.example.noteappai.domain.use_cases

import com.example.noteappai.data.local.NoteDto
import com.example.noteappai.domain.model.Note
import com.example.noteappai.domain.repository.NoteRepository

class DeleteNoteUseCAse(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: NoteDto){
        repository.deleteNote(note)
    }

}