package com.example.notesapp.feature_notes.domain.use_cases

data class NoteUseCases(
    val getNotes: GetNotesUseCase,
    val getNoteId: GetNoteIdUseCase,
    val addNote: InsertNoteUseCase,
    val deleteNote: DeleteNoteUseCase,
    val updateNote: UpdateNoteUseCase
)
//All use cases are bind together