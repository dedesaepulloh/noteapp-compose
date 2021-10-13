package com.dedesaepulloh.noteapp.feature.domain.usecase

import com.dedesaepulloh.noteapp.feature.domain.model.InvalidNoteException
import com.dedesaepulloh.noteapp.feature.domain.model.Note
import com.dedesaepulloh.noteapp.feature.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note){
        if (note.title.isBlank()){
            throw InvalidNoteException("The title can't be empty.")
        }
        if (note.content.isBlank()){
            throw InvalidNoteException("The content can't be empty.")
        }

        repository.insertNote(note)
    }
}