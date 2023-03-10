package com.project.domain.repository

import com.project.room.model.CompetitionsUiState
import kotlinx.coroutines.flow.Flow

interface GetAllCompetitionRepository {

    fun getAllCompetitions(): Flow<List<CompetitionsUiState>>

    suspend fun insertAllCompetitions()
}