package com.dedesaepulloh.noteapp.feature.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dedesaepulloh.noteapp.feature.domain.model.Note

@Database(
    entities = [Note::class], version = 1
)
abstract class NoteDatabase : RoomDatabase() {
    abstract val noteDao: NoteDao

    companion object{
        const val DATABASE_NAME = "db_notes"
    }

}