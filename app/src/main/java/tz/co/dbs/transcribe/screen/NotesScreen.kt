package tz.co.dbs.transcribe.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import tz.co.dbs.transcribe.component.NoteCard
import tz.co.dbs.transcribe.component.form.RoundedButton
import tz.co.dbs.transcribe.component.form.RoundedTextField
import tz.co.dbs.transcribe.model.Note

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(
    modifier: Modifier = Modifier,
    notes: List<Note>,
    onInsert: (Note) -> Unit,
    onDelete: (Note) -> Unit
) {

    var title by remember {
        mutableStateOf("")
    }

    var description by remember {
        mutableStateOf("")
    }

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Transcribe")
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = modifier.padding(innerPadding).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            RoundedTextField(
                modifier = modifier.fillMaxWidth(),
                label = "Title",
                value = title,
                onValueChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) title = it
                }
            )

            RoundedTextField(
                modifier = modifier.fillMaxWidth(),
                label = "Description",
                value = description,
                onValueChange = {
                    if (it.all { char ->
                            char.isLetter() || char.isWhitespace()
                        }) description = it
                }
            )

            RoundedButton(
                onClick = {
                    if (title.isNotEmpty() && description.isNotEmpty()) {
                        val note = Note(title = title, description = description)
                        onInsert(note)
                        title = ""
                        description = ""
                        Toast.makeText(context, "Note Saved!", Toast.LENGTH_SHORT).show()
                    }
                },
                label = "Save"
            )

            HorizontalDivider()

            LazyColumn {
                items(notes) { note ->
                    NoteCard(note = note, onNoteClicked = onDelete)
                }
            }
        }
    }
}


@Composable
@Preview(showBackground = true)
fun NotesScreenPreview() {
    NotesScreen(
        notes = listOf(),
        onInsert = {},
        onDelete = {}
    )
}