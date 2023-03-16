package com.competition.detail.data.datasource.matches

import com.project.room.model.Match
import com.project.room.model.MatchesByDate
import kotlinx.coroutines.flow.Flow

interface RDSGetMatchesByDate {

    fun getMatchesByDate(): Flow<List<MatchesByDate>>

    suspend fun fetchMatchesByDateAndInsertIntoDB(id: Long, date: String)

}