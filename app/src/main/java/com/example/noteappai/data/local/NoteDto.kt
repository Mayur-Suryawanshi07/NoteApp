package com.example.noteappai.data.local

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime

@Entity(tableName = "notes")
data class NoteDto (
    @PrimaryKey(autoGenerate = false)
    val id: Int?=null,

    val title: String,
    val content: String,
    val color: Color,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

