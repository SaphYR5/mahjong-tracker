package com.example.mahjongtracker.ui.track

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import com.example.mahjongtracker.PlayerDetailsDialog
import com.example.mahjongtracker.PlayerWinDialog
import com.example.mahjongtracker.R

class TrackGameScreen {

}

@Composable
fun MahjongLayout(modifier: Modifier = Modifier) {
    var playerNames = remember { mutableStateListOf<String>("Player 1", "Player 2", "Player 3", "Player 4") }
    var playerScores = remember { mutableStateListOf<Int>(0, 0, 0, 0) }

    var playerExpanded by remember { mutableStateOf(false) }
    var playerExpandedIndex by remember { mutableIntStateOf(0) }
    val maxNameLength = 12;

    var winExpanded by remember { mutableStateOf(false) }
    var winner by remember { mutableIntStateOf(0) }

    PlayerCards(
        playerNames = playerNames,
        playerScores = playerScores,
        onCardClicked = { index -> playerExpandedIndex = index; playerExpanded = true },
        modifier = modifier
    )

    if (playerExpanded) {
        PlayerDetailsDialog(
            playerNames[playerExpandedIndex],
            onNameChanged = { if (it.length < maxNameLength) playerNames[playerExpandedIndex] = it },
            onDismissRequest = { playerExpanded = false }
        )
    }

    PlayerWinDialog(
        playerNames = playerNames,
        winner = winner,
        onWinnerSelected = { winner = playerNames.indexOf(it) },
        onDismissRequest = { winExpanded = false }
    )
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