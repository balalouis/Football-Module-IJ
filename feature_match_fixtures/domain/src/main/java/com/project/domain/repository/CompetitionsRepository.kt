package com.project.domain.repository

import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepository {

    fun getAllMatches(): Flow<List<Match>>

    suspend fun insertMatchList()
}