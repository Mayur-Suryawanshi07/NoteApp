package com.example.noteappai.data.local

import androidx.compose.ui.graphics.Color
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.noteappai.domain.model.Note
import java.time.LocalDateTime
import java.util.UUID

@Entity(tableName = "notes")
data class NoteDto (
    @PrimaryKey(autoGenerate = false)
    val id: String = UUID.randomUUID().toString(),
    val title: String,
    val content: String,
    val color: Color,
    val timestamp: LocalDateTime = LocalDateTime.now()
)

fun NoteDto.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content,
        color = color,
        timestamp = timestamp
    )
}