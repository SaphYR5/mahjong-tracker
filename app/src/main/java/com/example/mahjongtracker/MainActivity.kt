package com.example.mahjongtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.mahjongtracker.ui.navigation.MahjongNavHost
import com.example.mahjongtracker.ui.theme.MahjongTrackerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            MahjongTrackerTheme {
                val navController = rememberNavController()
                MahjongNavHost(
                    navController = navController,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}