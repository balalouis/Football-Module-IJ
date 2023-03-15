package com.project.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.project.room.model.CompetitionsUiState
import com.project.room.model.Match
import com.project.room.model.RoomTeam
import com.project.room.model.Table
import kotlinx.coroutines.flow.Flow

@Dao
interface FootballDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMatchList(matchList: List<Match>)

    @Query("SELECT * FROM match_list_table")
    fun getAllMatch(): Flow<List<Match>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCompetitionList(competitionUiStateList: List<CompetitionsUiState>)

    @Query("SELECT * FROM competitions_list_table")
    fun getAllCompetitions(): Flow<List<CompetitionsUiState>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTableList(tableList: List<Table>)

    @Query("SELECT * FROM table_list")
    fun getTableList(): Flow<List<Table>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertRoomTeamList(roomTeamList: List<RoomTeam>)

    @Query("SELECT * FROM team_list")
    fun getRoomTeamList(): Flow<List<RoomTeam>>
}