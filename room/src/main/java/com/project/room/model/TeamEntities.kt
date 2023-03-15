package com.project.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "team_list")
data class RoomTeam(
    @PrimaryKey(autoGenerate = false)
    val name: String,
    val crest: String,
)