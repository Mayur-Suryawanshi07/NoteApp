package com.example.noteappai.di

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.noteappai.data.local.noteDao


@Database(
    entities = [],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao(): noteDao

    companion object {
        private const val DB_Name="note_db"
    }

}