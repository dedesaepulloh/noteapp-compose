package com.dedesaepulloh.noteapp.di

import android.app.Application
import androidx.room.Room
import com.dedesaepulloh.noteapp.feature.data.repository.RepositoryImp
import com.dedesaepulloh.noteapp.feature.data.source.NoteDatabase
import com.dedesaepulloh.noteapp.feature.domain.repository.NoteRepository
import com.dedesaepulloh.noteapp.feature.domain.usecase.AddNote
import com.dedesaepulloh.noteapp.feature.domain.usecase.DeleteNote
import com.dedesaepulloh.noteapp.feature.domain.usecase.GetNotes
import com.dedesaepulloh.noteapp.feature.domain.usecase.NoteUseCases
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
    fun provideNoteDatabase(app: Application) : NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository{
        return RepositoryImp(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository)
        )
    }
}