package com.example.mahjongtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
}

@Composable
fun MahjongLayout(modifier: Modifier = Modifier) {
    var playerNames = remember { mutableStateListOf<String>("Player 1", "Player 2", "Player 3", "Player 4") }
    var playerScores = remember { mutableStateListOf<Int>(0, 0, 0, 0) }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            PlayerCard(name = playerNames[0], score = playerScores[0])
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            PlayerCard(name = playerNames[1], score = playerScores[1])
            Spacer(modifier = Modifier.size(128.dp))
            PlayerCard(name = playerNames[2], score = playerScores[2])
        }
        Row(
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            PlayerCard(name = playerNames[3], score = playerScores[3])
        }
    }
}

@Composable
fun PlayerCard(
    name: String,
    score: Int,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier) {
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
                text = "0"
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