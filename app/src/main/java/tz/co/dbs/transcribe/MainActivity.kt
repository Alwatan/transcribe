package tz.co.dbs.transcribe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dagger.hilt.android.AndroidEntryPoint
import tz.co.dbs.transcribe.screen.NoteViewModel
import tz.co.dbs.transcribe.screen.NotesScreen
import tz.co.dbs.transcribe.ui.theme.TranscribeTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TranscribeTheme {
                val noteViewModel: NoteViewModel by viewModels()
                TranscribeApp(noteViewModel)
            }
        }
    }
}

@Composable
fun TranscribeApp(noteViewModel: NoteViewModel = viewModel()) {

    val notes = noteViewModel.notes.collectAsState(initial = emptyList()).value

    NotesScreen(
        notes = notes,
        onInsert = { note ->
            noteViewModel.insert(note)
        },
        onDelete = { note ->
            noteViewModel.delete(note)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TranscribeTheme {
        TranscribeApp()
    }
}