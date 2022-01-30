package com.allometry.quicknote

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.allometry.quicknote.screen.NoteScreen
import com.allometry.quicknote.screen.NoteViewModel
import com.allometry.quicknote.ui.theme.QuickNoteTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuickNoteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    //val noteViewModel: NoteViewModel by viewModels()
                    val noteViewModel = viewModel<NoteViewModel>()
                    NotesApp(noteViewModel = noteViewModel)
            }
        }
    }
}


@Composable
fun NotesApp(noteViewModel: NoteViewModel  )
{
    NoteScreen(notes = noteViewModel.noteList.collectAsState().value, onRemoveNote = {
        noteViewModel.removeNote(it)
    }, onAddNote = {
        noteViewModel.addNote(it)
    })
}
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    QuickNoteTheme {
        Greeting("Android")
    }
}