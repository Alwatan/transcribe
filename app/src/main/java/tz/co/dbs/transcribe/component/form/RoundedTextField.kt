package tz.co.dbs.transcribe.component.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RoundedTextField(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    onImeAction: () -> Unit = {}
) {

    val controller = LocalSoftwareKeyboardController.current

    TextField(
        modifier = modifier.padding(vertical = 6.dp, horizontal = 12.dp),
        value = value,
        onValueChange = onValueChange,
        label = { Text(text = label)},
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            onImeAction()
            controller?.hide()
        })
    )
}


@Composable
@Preview(showBackground = true)
fun RoundedTextFieldPreview() {
    RoundedTextField(
        value = "",
        onValueChange = {},
        label = "Title"
    )
}