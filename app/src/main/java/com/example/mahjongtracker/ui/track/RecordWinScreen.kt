package com.example.mahjongtracker.ui.track

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mahjongtracker.ui.theme.MahjongTrackerTheme

class RecordWinScreen {
}

@Composable
fun RecordWinLayout(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

    }
}

@Preview(showBackground = true)
@Composable
fun RecordWinScreenPreview() {
    MahjongTrackerTheme {
        RecordWinLayout(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        )
    }
}