package com.example.mahjongtracker.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PlayerDao {
    @Insert
    suspend fun insertAll(players: List<Player>): List<Int>

    @Query("UPDATE players SET name = :name WHERE playerId = :playerId")
    suspend fun updateName(playerId: Int, name: String)

    @Query("UPDATE players SET score = score + :amount WHERE playerId = :playerId")
    suspend fun updateScore(playerId: Int, amount: Int)
}