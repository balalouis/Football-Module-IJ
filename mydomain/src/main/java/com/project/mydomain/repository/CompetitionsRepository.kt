package com.project.mydomain.repository

import com.project.network.hilt.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepository {

    suspend fun getAllMatches(): Flow<TodayMatchEntities.DomainMatchResponse>

}