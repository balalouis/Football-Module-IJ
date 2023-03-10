package com.project.data.datasource

import com.project.room.model.CompetitionsUiState
import kotlinx.coroutines.flow.Flow

interface RemoteDataSourceCompetitions {

    fun getAllCompetitions(): Flow<List<CompetitionsUiState>>

    suspend fun fetchAllCompetitionsAndInsertIntoDB()
}