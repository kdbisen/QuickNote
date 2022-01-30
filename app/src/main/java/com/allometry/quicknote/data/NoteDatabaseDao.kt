package com.allometry.quicknote.data

import androidx.compose.runtime.MutableState
import androidx.room.*
import com.allometry.quicknote.model.Note
import kotlinx.coroutines.flow.Flow


@Dao
interface NoteDatabaseDao
{
    @Query("select * from notes_tbl")
    fun getAllNotes() : Flow<List<Note>>

    @Query("select * from notes_tbl where id =:id")
    suspend fun getNoteByID(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note: Note)

    @Query("DELETE from notes_tbl")
    suspend fun deleteAll()

    @Delete
    suspend fun deleteNote(note: Note)
}