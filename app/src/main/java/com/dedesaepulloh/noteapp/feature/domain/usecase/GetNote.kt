package com.dedesaepulloh.noteapp.feature.domain.usecase

import com.dedesaepulloh.noteapp.feature.domain.model.Note
import com.dedesaepulloh.noteapp.feature.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}