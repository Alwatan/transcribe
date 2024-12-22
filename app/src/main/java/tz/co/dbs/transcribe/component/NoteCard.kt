package tz.co.dbs.transcribe.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tz.co.dbs.transcribe.data.NotesDataSource
import tz.co.dbs.transcribe.model.Note
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun NoteCard(
    modifier: Modifier = Modifier,
    note: Note,
    onNoteClicked: (Note) -> Unit
) {
    Surface(
        modifier = modifier.fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 12.dp)
            .height(120.dp),
        shape = RoundedCornerShape(12.dp),
        color = MaterialTheme.colorScheme.primaryContainer
    ) {
        Column(
            modifier= modifier.padding(12.dp).clickable {
                onNoteClicked(note)
            }
        ) {
            Text(
                text = note.title,
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = note.description,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = modifier.weight(1f))

            Text(
                text = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault()).format(note.createdAt),
                style = MaterialTheme.typography.labelMedium
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun NoteCardPreview(){
    val note  = NotesDataSource.loadNotes().get(0)
    NoteCard(note = note, onNoteClicked = {})
}