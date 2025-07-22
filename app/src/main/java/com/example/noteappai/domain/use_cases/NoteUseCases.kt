package com.example.noteappai.domain.use_cases

data class NoteUseCases(
    val GetNotes: GetNotesUseCase,
    val GetNoteId: GetNoteIdUseCase,
    val AddNote: InsertNoteUseCase,
    val DeleteNote: DeleteNoteUseCAse,
    val UpdateNote: UpdateNoteUseCase
)
//All use cases are binded together