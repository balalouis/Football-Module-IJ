package com.project.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_list")
data class TableUiState(
    @PrimaryKey(autoGenerate = false)
    val standings: List<Standing>
)

data class Standing(
    val table: List<Table>
)

data class Table(
    val position: Int,
    val team: Team,
    val playedGames: Int,
    val goalDifference: Int,
    val points: Int,
)

data class Team(
    val crest: String,
    val name: String,
)

