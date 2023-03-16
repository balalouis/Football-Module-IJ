package com.competition.detail.domain.repo

import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow

interface MatchesByDateRepository {

    fun getMatchesByDate(): Flow<List<Match>>

    suspend fun insertMatchesByDateList()
}