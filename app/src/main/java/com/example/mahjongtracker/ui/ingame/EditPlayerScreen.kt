package com.example.mahjongtracker.ui.ingame

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mahjongtracker.ui.theme.MahjongTrackerTheme

@Composable
fun EditPlayerLayout(
    modifier: Modifier = Modifier
) {

}

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