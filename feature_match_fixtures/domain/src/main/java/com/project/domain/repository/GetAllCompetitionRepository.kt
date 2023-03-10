package com.project.domain.repository

import com.project.room.model.Competitions
import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow

interface GetAllCompetitionRepository {

    fun getAllCompetitions(): Flow<List<Competitions>>

    suspend fun insertAllCompetitions()
}