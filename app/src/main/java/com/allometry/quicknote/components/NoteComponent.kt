package com.allometry.quicknote.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import com.allometry.quicknote.model.Note
import java.time.format.DateTimeFormatter


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun NoteInputText(modifier: Modifier = Modifier, text : String, label : String, maxLine: Int = 1,
onTextChange: (String) -> Unit, onImeAction: () -> Unit = {})
{

    val keyboardControllerLocalContext  = LocalSoftwareKeyboardController.current


 TextField(modifier = modifier, value = text, onValueChange = onTextChange, colors = TextFieldDefaults.textFieldColors(
     backgroundColor = Color.Transparent ), maxLines = maxLine, label = {Text(text = label)},
     keyboardOptions = KeyboardOptions.Default.copy( imeAction = ImeAction.Done ) ,
     keyboardActions = KeyboardActions (onDone = {
         onImeAction()
         keyboardControllerLocalContext?.hide()
     }))
}

@Composable
fun NoteButton (text: String,
                modifier: Modifier = Modifier,
                onClick: () -> Unit,
                enabled: Boolean = true) {

    Button(modifier = modifier , onClick = onClick, shape = CircleShape, enabled = enabled) {
        Text(text = text)
    }
}


@Composable
fun NoteRow (modifier: Modifier = Modifier, note: Note, onNoteClick : (Note) -> Unit )
{

    Surface(modifier = modifier
        .padding(4.dp)
        .clip(RoundedCornerShape(topEnd = 33.dp, bottomStart = 33.dp))
        .fillMaxWidth(),
    color = Color(0xFF37A3E9),
        elevation = 6.dp
    ) {
     Column(modifier = Modifier
         .clickable { onNoteClick(note)
         }
         .padding(horizontal = 14.dp, vertical = 6.dp),
     horizontalAlignment = Alignment.Start) {
         Text(text = note.title , style = MaterialTheme.typography.subtitle2 )
         Text(text = note.description, style = MaterialTheme.typography.subtitle1)
         Text(text = note.time.format(DateTimeFormatter.ofPattern("EEE, d MMM")), style = MaterialTheme.typography.subtitle2)
     }
    }
}
