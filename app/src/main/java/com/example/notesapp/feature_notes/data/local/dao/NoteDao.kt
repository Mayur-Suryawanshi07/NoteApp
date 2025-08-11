package com.example.notesapp.feature_notes.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.feature_notes.data.local.entity.NoteDto
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.Companion.REPLACE)
    suspend fun insertNote(noteDto: NoteDto)

    @Delete
    suspend fun deleteNoteById(noteDto: NoteDto)

    @Update
    suspend fun updateNote(noteDto: NoteDto)

    @Query("SELECT * FROM notes WHERE id = :id")
    suspend fun getNoteById(id: Int): NoteDto?

    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<NoteDto>>


}