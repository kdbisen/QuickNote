package com.allometry.quicknote.data

import com.allometry.quicknote.model.Note


class NotesDataSource {
    fun loadNotes(): List<Note> {

        return listOf(
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote"),
            Note(title = " A Movie Day", description = "My OwnNote")
        )
    }
}