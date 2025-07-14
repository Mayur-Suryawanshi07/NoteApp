package com.example.noteappai.data.repository

import com.example.noteappai.data.local.NoteDto
import com.example.noteappai.data.local.noteDao
import com.example.noteappai.domain.model.Note
import com.example.noteappai.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl(
    private val dao: noteDao
): NoteRepository {
    override fun getNotes(): Flow<List<NoteDto>> {
        return dao.getAllNotes()
    }

    override suspend fun getNoteById(id: Int): NoteDto? {
        return dao.getNoteById(id)
    }

    override suspend fun insertNote(note: NoteDto) {
        return dao.insertNote(note)
    }

    override suspend fun deleteNote(note: NoteDto) {
        return dao.deleteNoteById(note)
    }


}