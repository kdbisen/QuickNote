package com.allometry.quicknote.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.allometry.quicknote.model.Note
import com.allometry.quicknote.utils.Converters


@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class NoteDatabase: RoomDatabase(){
    abstract fun noteDao( ) : NoteDatabaseDao
}