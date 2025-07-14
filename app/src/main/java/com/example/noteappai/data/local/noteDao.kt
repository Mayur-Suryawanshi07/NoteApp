package com.example.noteappai.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface noteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(noteDto: NoteDto)

    @Delete
    suspend fun deleteNoteById(id: Int)

    @Update
    suspend fun updateNote(noteDto: NoteDto)

    @Query("SELECT * FROM notes WHERE id = :id")
    fun getNoteById(id: Int): Flow<NoteDto>

    @Query("SELECT * FROM notes")
    fun getAllNotes(): Flow<List<NoteDto>>


}