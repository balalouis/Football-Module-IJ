package com.project.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.project.room.model.*

@Database(entities = [Match::class], version = 1)
@TypeConverters(MatchTypeConverter::class, AwayTeamTypeConverter::class, HomeTeamTypeConverter::class, ScoreTypeConverter::class, FullTimeTypeConverter::class, HalfTimeTypeConverter::class)
abstract class FootballDatabase : RoomDatabase() {
    abstract fun footballDao(): FootballDao
}