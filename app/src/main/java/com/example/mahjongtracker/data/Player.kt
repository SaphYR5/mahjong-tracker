package com.example.mahjongtracker.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "players",
    foreignKeys = [ForeignKey(
        entity = Game::class,
        parentColumns = ["gameId"],
        childColumns = ["gameId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("gameId")]
)
data class Player(
    @PrimaryKey(autoGenerate = true)
    val playerId: Int = 0,
    val gameId: Int,
    val seat: Int,
    val name: String,
    val score: Int = 0 // Maybe change to long?
)
