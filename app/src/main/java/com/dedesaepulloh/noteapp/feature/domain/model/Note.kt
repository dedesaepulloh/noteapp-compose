package com.dedesaepulloh.noteapp.feature.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dedesaepulloh.noteapp.ui.theme.*

@Entity
data class Note(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val content: String,
    val timestamp: Long,
    val color: Int
){
    companion object{
        val noteColors = listOf(RedOrange, LightGreen, Violet, BabyBlue, RedPink)
    }
}
