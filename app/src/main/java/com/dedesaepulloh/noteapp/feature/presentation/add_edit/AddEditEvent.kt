package com.dedesaepulloh.noteapp.feature.presentation.add_edit

import androidx.compose.ui.focus.FocusState

sealed class AddEditEvent{
    data class EnteredTitle(val value: String): AddEditEvent()
    data class ChangeTitleFocus(val focusState: FocusState): AddEditEvent()
    data class EnteredContent(val value: String): AddEditEvent()
    data class ChangeContentFocus(val focusState: FocusState): AddEditEvent()
    data class ChangeColor(val color: Int): AddEditEvent()
    object SaveNote: AddEditEvent()
}
