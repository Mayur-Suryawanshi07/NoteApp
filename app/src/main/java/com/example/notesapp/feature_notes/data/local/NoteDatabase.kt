package com.example.notesapp.feature_notes.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.notesapp.feature_notes.data.local.dao.NoteDao
import com.example.notesapp.feature_notes.data.local.entity.NoteDto

@Database(

    entities = [NoteDto::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(Converters::class)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): NoteDao

}