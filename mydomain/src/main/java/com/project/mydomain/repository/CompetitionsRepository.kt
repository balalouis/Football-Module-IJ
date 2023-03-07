package com.project.mydomain.repository

import com.project.network.hilt.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepository {

    suspend fun getTodayMatches(date: String): Flow<TodayMatchEntities.DomainMatchResponse>

}