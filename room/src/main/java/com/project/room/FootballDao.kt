package com.project.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow

@Dao
interface FootballDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMatchList(matchList: List<Match>)

    @Query("SELECT * FROM match_list_table")
    fun getAllMatch(): Flow<List<Match>>
}