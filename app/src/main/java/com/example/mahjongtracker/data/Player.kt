package com.example.mahjongtracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "players")
data class Player(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val gameId: Int,
    val seat: Int,
    val name: String,
    val score: Int = 0 // Maybe change to long?
)
