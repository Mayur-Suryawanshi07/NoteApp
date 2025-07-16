package com.example.noteappai.data.repository

import com.example.noteappai.data.local.NoteDao
import com.example.noteappai.data.mapper.toNote
import com.example.noteappai.data.mapper.toNoteDto
import com.example.noteappai.domain.model.Note
import com.example.noteappai.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val dao: NoteDao
): NoteRepository {
    override fun getNotes(): Flow<List<Note>> {
        return dao.getAllNotes().map { it.map{it.toNote()}}
    }

    override suspend fun getNoteById(id: Int): Note? {
        return dao.getNoteById(id)?.toNote()
    }

    override suspend fun insertNote(note: Note) {
        return dao.insertNote(note.toNoteDto())
    }

    override suspend fun deleteNote(note: Note) {
        return dao.deleteNoteById(note.toNoteDto())
    }


}