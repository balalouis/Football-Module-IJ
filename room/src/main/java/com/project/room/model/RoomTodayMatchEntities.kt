package com.project.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "match_list_table")
data class Match(
    @PrimaryKey(autoGenerate = false)
    val awayTeam: AwayTeam,
    val homeTeam: HomeTeam? =null,
    val matchday: Int = 0,
    val score: Score? =null,
    val status: String = "",
    val utcDate: String =""
)


@Entity(tableName = "matches_by_date_list_table")
data class MatchesByDate(
    @PrimaryKey(autoGenerate = false)
    val awayTeam: AwayTeam,
    val homeTeam: HomeTeam? =null,
    val matchday: Int = 0,
    val score: Score? =null,
    val status: String = "",
    val utcDate: String =""
)

data class AwayTeam(
    val name: String? = ""
)

data class HomeTeam(
    val name: String? = ""
)

data class Score(
    val fullTime: FullTime?=null,
    val halfTime: HalfTime?=null
)

data class FullTime(
    val away: Int? =0,
    val home: Int? =0
)

data class HalfTime(
    val away: Int? =0,
    val home: Int? =0
)
