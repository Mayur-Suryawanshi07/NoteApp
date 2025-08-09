package com.example.notesapp.di

import android.app.Application
import androidx.room.Room
import com.example.notesapp.data.local.NoteDatabase
import com.example.notesapp.data.local.NoteDao
import com.example.notesapp.data.repository.NoteRepositoryImpl
import com.example.notesapp.domain.repository.NoteRepository
import com.example.notesapp.domain.use_cases.DeleteNoteUseCAse
import com.example.notesapp.domain.use_cases.GetNoteIdUseCase
import com.example.notesapp.domain.use_cases.GetNotesUseCase
import com.example.notesapp.domain.use_cases.InsertNoteUseCase
import com.example.notesapp.domain.use_cases.NoteUseCases
import com.example.notesapp.domain.use_cases.UpdateNoteUseCase
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
            ).fallbackToDestructiveMigration(true)
            .build()

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
            GetNotes = GetNotesUseCase(repository),
            GetNoteId =  GetNoteIdUseCase(repository),
            AddNote = InsertNoteUseCase(repository),
            DeleteNote = DeleteNoteUseCAse(repository),
            UpdateNote = UpdateNoteUseCase(repository)
        )
    }

}
//all the singleton implementation is happen here