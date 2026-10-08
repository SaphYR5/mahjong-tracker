package com.example.mahjongtracker.ui.track

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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

    PlayerCards(
        playerNames = playerNames,
        playerScores = playerScores,
        onCardClicked = { },
        modifier = modifier
    )
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