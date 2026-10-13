package com.example.mahjongtracker.ui.ingame

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
    onChangeClick: () -> Unit,
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
        ChangeButton(
            onClick = onChangeClick,
            modifier = Modifier.fillMaxWidth()
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

@Composable
fun ChangeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text("Confirm")
    }
}


@Preview(showBackground = true)
@Composable
fun EditPlayerScreenPreview() {
    MahjongTrackerTheme {
        EditPlayerLayout(
            onChangeClick = {},
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}