package com.example.noteappai.domain.repository

import com.example.noteappai.data.local.NoteDto
import com.example.noteappai.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

   fun getNotes(): Flow<List<NoteDto>>

   suspend fun getNoteById(id: Int): NoteDto?

   suspend fun insertNote(note: NoteDto)

   suspend fun deleteNote(note: NoteDto)


}