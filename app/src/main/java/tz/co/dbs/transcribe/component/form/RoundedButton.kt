package tz.co.dbs.transcribe.component.form

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RoundedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    label: String
) {
    Button(
        modifier = modifier.padding(vertical = 6.dp, horizontal = 12.dp),
        onClick = onClick
    ) {
        Text(text = label)
    }
}

@Composable
@Preview(showBackground = true)
fun RoundedButtonPreview() {
    RoundedButton(
        onClick = {},
        label = "Save"
    )
}