package com.example.noteappai.data.mapper

import com.example.noteappai.data.local.NoteDto
import com.example.noteappai.domain.model.Note

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