package com.project.data.datasource

import com.project.network.hilt.model.competitions.CompetitionsEntities
import kotlinx.coroutines.flow.Flow

interface RemoteDataSourceCompetitions {

    fun getAllCompetitions(): Flow<List<CompetitionsEntities.Competition>>

    suspend fun fetchAllCompetitionsAndInsertIntoDB()
}