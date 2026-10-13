package com.example.mahjongtracker.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mahjongtracker.ui.ingame.RecordWinLayout
import com.example.mahjongtracker.ui.ingame.TrackGameLayout

enum class MahjongScreen() {
    TrackGame,
    RecordWin
}

@Composable
fun MahjongNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MahjongScreen.TrackGame.name,
        modifier = modifier
    ) {
        composable(route = MahjongScreen.TrackGame.name) {
            TrackGameLayout(
                onRecordClick = { navController.navigate(MahjongScreen.RecordWin.name) },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
        composable(route = MahjongScreen.RecordWin.name) {
            RecordWinLayout(
                onConfirmClick = { navController.navigate(MahjongScreen.TrackGame.name) },
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            )
        }
    }
}