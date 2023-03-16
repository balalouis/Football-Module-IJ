package com.competition.detail.data.datasource.matches

import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow

interface RDSGetMatchesByDate {

    fun getMatchesByDate(): Flow<List<Match>>

    suspend fun fetchMatchesByDateAndInsertIntoDB()

}