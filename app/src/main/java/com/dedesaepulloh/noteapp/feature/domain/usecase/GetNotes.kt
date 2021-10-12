package com.dedesaepulloh.noteapp.feature.domain.usecase

import com.dedesaepulloh.noteapp.feature.domain.model.Note
import com.dedesaepulloh.noteapp.feature.domain.repository.NoteRepository
import com.dedesaepulloh.noteapp.feature.domain.utils.NoteOrder
import com.dedesaepulloh.noteapp.feature.domain.utils.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotes(
    private val respository: NoteRepository
) {
    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>>{
        return respository.getNotes().map { notes ->
            when(noteOrder.orderType){
                is OrderType.Ascending ->  {
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedBy { it.timestamp }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
                is OrderType.Descending ->  {
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date -> notes.sortedByDescending { it.timestamp }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}