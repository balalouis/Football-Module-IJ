package com.project.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Standing(
    val table: List<Table>
)

@Entity(tableName = "table_list")
data class Table(
    @PrimaryKey(autoGenerate = false)
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

