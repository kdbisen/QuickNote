package com.allometry.quicknote.screen

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.allometry.quicknote.data.NotesDataSource
import com.allometry.quicknote.model.Note

class NoteViewModel : ViewModel() {

    private var noteList = mutableStateListOf<Note>()

    init {
       // noteList.addAll(NotesDataSource().loadNotes())
    }

    fun addNote(note: Note)
    {
        noteList.add(note)
    }

    fun removeNote(note: Note)
    {
        Log.d("TAG", "removeNote: ${note.toString()}")
        noteList.remove(note)
    }

    fun getAllNotes() : List<Note> {
        return  noteList
    }

}