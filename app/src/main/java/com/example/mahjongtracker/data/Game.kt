package com.example.mahjongtracker.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class Game(
    @PrimaryKey(autoGenerate = true)
    val gameId: Int = 0,
    val gameName: String,
    val dateCreated: Long,
    val dateLastAccessed: Long
)
