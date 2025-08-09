package com.example.notesapp.domain.use_cases

data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val getNoteId: GetNoteIdUseCase,
    val addNote: InsertNoteUseCase,
    val deleteNote: DeleteNoteUseCAse,
    val updateNote: UpdateNoteUseCase
)
//All use cases are bind together