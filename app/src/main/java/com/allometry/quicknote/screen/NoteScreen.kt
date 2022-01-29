package com.allometry.quicknote.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.allometry.quicknote.R
import com.allometry.quicknote.components.NoteButton
import com.allometry.quicknote.components.NoteInputText
import com.allometry.quicknote.components.NoteRow
import com.allometry.quicknote.data.NotesDataSource
import com.allometry.quicknote.model.Note

@Composable
fun NoteScreen (notes: List<Note>,
onAddNote: (Note) -> Unit,
onRemoveNote : (Note) -> Unit)
{

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }


    val context = LocalContext.current

    Column(modifier = Modifier.padding(6.dp)) {
       TopAppBar(title = { Text(text = stringResource(id = R.string.app_name))}, actions = {
           Icon(imageVector = Icons.Rounded.Notifications, contentDescription = "Home Icon")
       },
       backgroundColor = Color(0xFFADAFE3)
       )

        Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {

            NoteInputText(text = title, label = "Title",
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                onTextChange = {
                    if(it.all {
                        char -> char.isLetter() || char.isWhitespace()
                        })
                        title = it

            })


            NoteInputText(text = description, label = "Add a note",
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                onTextChange = {
                    if(it.all {
                                char -> char.isLetter() || char.isWhitespace()
                        })
                        description = it
            })
            
            NoteButton(text = "Save",
                modifier = Modifier.padding(top = 9.dp, bottom = 8.dp),
                onClick = {

                    if(title.isNotEmpty() && description.isNotEmpty()) {
                        onAddNote(Note (title = title, description = description))
                        title = ""
                        description = ""
                        Toast.makeText(context, "Note added", Toast.LENGTH_LONG).show()
                    }
                })

            Divider(
                Modifier
                    .fillMaxWidth()
                    .padding(10.dp))

            LazyColumn() {
                items(notes) {
                    note ->
                    NoteRow(note = note, onNoteClick = {
                        onRemoveNote(it)
                    })

                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun NoteScreenPreview( ){
    NoteScreen(notes = NotesDataSource().loadNotes(), onAddNote = {}, onRemoveNote =  {})
}