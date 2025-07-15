package com.example.noteappai.domain.use_cases

import com.example.noteappai.data.local.NoteDto
import com.example.noteappai.domain.model.Note
import com.example.noteappai.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCAse @Inject constructor(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }

}