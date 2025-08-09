package com.example.notesapp.data.mapper

import com.example.notesapp.data.local.NoteDto
import com.example.notesapp.domain.model.Note

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