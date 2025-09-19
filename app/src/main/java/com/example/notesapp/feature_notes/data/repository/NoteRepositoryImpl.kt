package com.example.notesapp.feature_notes.data.repository

import com.example.notesapp.feature_notes.data.local.dao.NoteDao
import com.example.notesapp.feature_notes.data.mapper.toNote
import com.example.notesapp.feature_notes.data.mapper.toNoteDto
import com.example.notesapp.feature_notes.domain.model.Note
import com.example.notesapp.feature_notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val dao: NoteDao
): NoteRepository {

    override fun getNotes(): Flow<List<Note>> {
        return dao.getAllNotes().map { it.map{ it -> it.toNote()}}
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

    override suspend fun updateNote(note: Note) {
        return dao.updateNote(note.toNoteDto())
    }
}