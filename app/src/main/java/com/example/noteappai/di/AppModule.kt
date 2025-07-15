package com.example.noteappai.di

import android.app.Application
import androidx.room.Room
import com.example.noteappai.data.local.NoteDatabase
import com.example.noteappai.data.local.noteDao
import com.example.noteappai.data.repository.NoteRepositoryImpl
import com.example.noteappai.domain.repository.NoteRepository
import com.example.noteappai.domain.use_cases.DeleteNoteUseCAse
import com.example.noteappai.domain.use_cases.GetNoteIdUseCase
import com.example.noteappai.domain.use_cases.GetNotesUseCase
import com.example.noteappai.domain.use_cases.InsertNoteUseCase
import com.example.noteappai.domain.use_cases.NoteUseCases
import com.example.noteappai.presentation.navigation.Screen
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
    fun provideDao(noteDatabase: NoteDatabase): noteDao {
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
            DeleteNote = DeleteNoteUseCAse(repository)
        )
    }

}
//all the singleton implementation is happen here