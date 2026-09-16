package com.example.mahjongtracker

import android.os.Bundle
import android.view.View
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
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.core.view.WindowCompat
import android.view.Window
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.core.view.WindowCompat.setDecorFitsSystemWindows
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
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

@Composable
fun MahjongLayout(modifier: Modifier = Modifier) {
    var playerNames = remember { mutableStateListOf<String>("Player 1", "Player 2", "Player 3", "Player 4") }
    var playerScores = remember { mutableStateListOf<Int>(0, 0, 0, 0) }

    var playerExpanded by remember { mutableStateOf(false) }
    var playerExpandedIndex by remember { mutableIntStateOf(0) }
    val maxNameLength = 12;

    PlayerCards(
        playerNames = playerNames,
        playerScores = playerScores,
        onCardClicked = { index -> playerExpandedIndex = index; playerExpanded = true },
        modifier = modifier
    )

    if (playerExpanded) {
        EditPlayerDetails(
            playerNames[playerExpandedIndex],
            onNameChanged = { if (it.length < maxNameLength) playerNames[playerExpandedIndex] = it },
            onDismissRequest = { playerExpanded = false }
        )
    }
}

@Composable
fun EditPlayerDetails(
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
                modifier = Modifier
                    .size(240.dp)
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
                        imeAction = ImeAction.Done
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

@Composable
fun PlayerCards(
    playerNames: List<String>,
    playerScores: List<Int>,
    onCardClicked: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            PlayerCard(
                name = playerNames[0],
                score = playerScores[0],
                onCardClicked = { onCardClicked(0) }
            )
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            PlayerCard(
                name = playerNames[1],
                score = playerScores[1],
                onCardClicked = { onCardClicked(1) }
            )
            Spacer(modifier = Modifier.weight(1f))
            PlayerCard(
                name = playerNames[2],
                score = playerScores[2],
                onCardClicked = { onCardClicked(2) }
            )
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            PlayerCard(
                name = playerNames[3],
                score = playerScores[3],
                onCardClicked = { onCardClicked(3) }
            )
        }
    }
}

@Composable
fun PlayerCard(
    name: String,
    score: Int,
    onCardClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onCardClicked,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = name
            )
            Icon(
                painter = painterResource(R.drawable.ic_launcher_foreground),
                contentDescription = null
            )
            Text(
                text = score.toString()
            )
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