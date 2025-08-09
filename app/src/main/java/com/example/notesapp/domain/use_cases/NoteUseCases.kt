package com.example.notesapp.domain.use_cases

data class NoteUseCases(
    val GetNotes: GetNotesUseCase,
    val GetNoteId: GetNoteIdUseCase,
    val AddNote: InsertNoteUseCase,
    val DeleteNote: DeleteNoteUseCAse,
    val UpdateNote: UpdateNoteUseCase
)
//All use cases are bind together