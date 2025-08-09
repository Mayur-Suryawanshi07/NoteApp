package com.example.notesapp.domain.use_cases

import com.example.notesapp.domain.model.Note
import com.example.notesapp.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCAse @Inject constructor(
    private val repository: NoteRepository
) {

    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }

}