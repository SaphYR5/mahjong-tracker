package com.example.mahjongtracker.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    @Transaction
    @Query("SELECT * FROM games ORDER BY dateLastAccessed DESC")
    abstract fun getAllGames(): Flow<List<Game>>

    @Query("SELECT * FROM games WHERE gameId = :gameId")
    abstract fun getGame(gameId: Int): Flow<Game>

    @Query("UPDATE games SET dateLastAccessed = :timestamp WHERE gameId = :gameId")
    abstract fun touch(gameId: Int, timestamp: Long)

    @Query("DELETE FROM games WHERE gameId = :gameId")
    abstract fun deleteGame(gameId: Int)
}