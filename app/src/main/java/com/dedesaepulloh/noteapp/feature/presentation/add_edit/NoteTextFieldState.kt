package com.dedesaepulloh.noteapp.feature.presentation.add_edit

data class NoteTextFieldState(
    val text: String = "",
    val hint: String = "",
    val isHintVisible: Boolean = true
)
