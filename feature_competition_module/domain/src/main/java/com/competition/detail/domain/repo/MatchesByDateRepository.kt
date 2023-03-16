package com.competition.detail.domain.repo

import com.project.room.model.Match
import com.project.room.model.MatchesByDate
import kotlinx.coroutines.flow.Flow

interface MatchesByDateRepository {

    fun getMatchesByDate(): Flow<List<MatchesByDate>>

    suspend fun insertMatchesByDateList(id: Long, date: String)
}