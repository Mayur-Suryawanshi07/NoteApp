package com.example.notesapp.feature_notes.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "notes")
data class NoteDto (
    @PrimaryKey(autoGenerate = true)
    val id: Int?=null,

    val title: String,
    val content: String,
    val color: Int, // ARGB Int stored in DB
    val timestamp: LocalDateTime = LocalDateTime.now()
)