package com.example.mahjongtracker

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardCapitalization
import com.example.mahjongtracker.ui.theme.MahjongTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MahjongTrackerTheme {
                MahjongPreview()
            }
        }
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        window.decorView.apply {
            // Hide both the navigation bar and the status bar.
            // SYSTEM_UI_FLAG_FULLSCREEN is only available on Android 4.1 and higher, but as
            // a general rule, you should design your app to hide the status bar whenever you
            // hide the navigation bar.
            systemUiVisibility = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlayerWinDialog(
    playerNames: List<String>,
    winner: Int,
    onWinnerSelected: (String) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    var playerExpanded by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            Card(
                modifier = Modifier.size(240.dp)
            ) {
                Text(
                    text = "Select winner",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                )
                ExposedDropdownMenuBox(
                    expanded = playerExpanded,
                    onExpandedChange = { playerExpanded = !playerExpanded },
                    modifier = Modifier.padding(8.dp)
                ) {
                    TextField(
                        value = playerNames[winner],
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = playerExpanded) },
                        modifier = Modifier.menuAnchor()
                    )
                    ExposedDropdownMenu(
                        expanded = playerExpanded,
                        onDismissRequest = { playerExpanded = false }
                    ) {
                        playerNames.forEach { playerName ->
                            DropdownMenuItem(
                                text = { Text(text = playerName) },
                                onClick = {
                                    onWinnerSelected(playerName)
                                    playerExpanded = false
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun PlayerDetailsDialog(
    playerName: String,
    onDismissRequest: () -> Unit,
    onNameChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.padding(16.dp),
        ) {
            Card(
                modifier = Modifier.size(240.dp)
            ) {
                Spacer(modifier = Modifier.size(24.dp))
                Text(
                    text = "Edit player name",
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(8.dp).fillMaxWidth()
                )
                TextField(
                    value = playerName,
                    singleLine = true,
                    onValueChange = onNameChanged,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done,
                        capitalization = KeyboardCapitalization.Words
                    ),
                    modifier = Modifier.padding(8.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    onClick = onDismissRequest,
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.End)
                ) {
                    Text(text = "Done")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MahjongPreview() {
    MahjongTrackerTheme {
        MahjongLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}