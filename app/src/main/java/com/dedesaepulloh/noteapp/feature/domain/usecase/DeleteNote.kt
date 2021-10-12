package com.dedesaepulloh.noteapp.feature.domain.usecase

import com.dedesaepulloh.noteapp.feature.domain.model.Note
import com.dedesaepulloh.noteapp.feature.domain.repository.NoteRepository

class DeleteNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note){
        repository.deleteNote(note)
    }
}