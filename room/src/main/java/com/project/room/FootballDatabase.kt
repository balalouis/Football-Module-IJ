package com.project.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.room.model.*

@Database(entities = [Match::class,CompetitionsUiState::class, Table::class, RoomTeam::class], version = 1)
@TypeConverters(MatchTypeConverter::class, AwayTeamTypeConverter::class,
    HomeTeamTypeConverter::class, ScoreTypeConverter::class,
    FullTimeTypeConverter::class, HalfTimeTypeConverter::class,
    CurrentSeasonTypeConverter::class, TableListConverter::class,TeamTypeConverter::class, TableTypeConverter::class,
    RoomTeamTypeConverter::class, MatchesByDate::class)
abstract class FootballDatabase : RoomDatabase() {
    abstract fun footballDao(): FootballDao
}