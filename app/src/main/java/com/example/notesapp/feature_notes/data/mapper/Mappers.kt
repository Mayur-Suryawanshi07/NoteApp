package com.example.notesapp.feature_notes.data.mapper

import com.example.notesapp.feature_notes.data.local.entity.NoteDto
import com.example.notesapp.feature_notes.domain.model.Note

fun NoteDto.toNote(): Note {
    return Note(
        id = id,
        title = title,
        content = content,
        color = color,
        timestamp = timestamp
    )
}

fun Note.toNoteDto(): NoteDto {
    return NoteDto(
        id = id,
        title = title,
        content = content,
        color = color,
        timestamp = timestamp
    )
}