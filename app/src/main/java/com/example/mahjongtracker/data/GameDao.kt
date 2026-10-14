package com.example.mahjongtracker.data

import androidx.room.Dao
import androidx.room.Insert
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

    @Insert
    abstract suspend fun insertGame(game: Game): Int

    @Insert
    abstract suspend fun insertPlayers(players: List<Player>): List<Int>

    @Transaction
    open suspend fun createGame(game: Game): Int {
        val gameId = insertGame(game)
        insertPlayers(
            List(4) { seat ->
                Player(gameId = gameId, seat = seat, name = "Player ${seat + 1}")
            }
        )
        return gameId
    }
}