package com.dedesaepulloh.noteapp.feature.presentation.notes

import com.dedesaepulloh.noteapp.feature.domain.model.Note
import com.dedesaepulloh.noteapp.feature.domain.utils.NoteOrder
import com.dedesaepulloh.noteapp.feature.domain.utils.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
