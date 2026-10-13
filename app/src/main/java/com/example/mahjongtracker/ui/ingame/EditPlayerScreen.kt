package com.example.mahjongtracker.ui.ingame

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mahjongtracker.ui.theme.MahjongTrackerTheme

@Composable
fun EditPlayerLayout(
    modifier: Modifier = Modifier
) {
    var playerName by remember { mutableStateOf("Name") }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text("Edit Player Details")
        EditNameField(
            name = playerName,
            onNameChanged = { playerName = it }
        )
    }
}

@Composable
fun EditNameField(
    name: String,
    onNameChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = name,
        onValueChange = onNameChanged,
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun EditPlayerScreenPreview() {
    MahjongTrackerTheme {
        EditPlayerLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}