package com.example.notesapp.feature_notes.di

import android.app.Application
import androidx.room.Room
import com.example.notesapp.feature_notes.data.local.NoteDatabase
import com.example.notesapp.feature_notes.data.local.dao.NoteDao
import com.example.notesapp.feature_notes.data.repository.NoteRepositoryImpl
import com.example.notesapp.feature_notes.domain.repository.NoteRepository
import com.example.notesapp.feature_notes.domain.use_cases.DeleteNoteUseCase
import com.example.notesapp.feature_notes.domain.use_cases.GetNoteIdUseCase
import com.example.notesapp.feature_notes.domain.use_cases.GetNotesUseCase
import com.example.notesapp.feature_notes.domain.use_cases.InsertNoteUseCase
import com.example.notesapp.feature_notes.domain.use_cases.NoteUseCases
import com.example.notesapp.feature_notes.domain.use_cases.UpdateNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
                app,
                NoteDatabase::class.java,
                "note_db"
            ).build()

    }

    @Provides
    @Singleton
    fun provideDao(noteDatabase: NoteDatabase): NoteDao {
        return noteDatabase.getNoteDao()
    }


    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.getNoteDao())
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotesUseCase(repository),
            getNoteId = GetNoteIdUseCase(repository),
            addNote = InsertNoteUseCase(repository),
            deleteNote = DeleteNoteUseCase(repository),
            updateNote = UpdateNoteUseCase(repository)
        )
    }

}
//all the singleton implementation is happen here