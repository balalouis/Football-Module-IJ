package com.project.mydomain.repository

import com.project.mydomain.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepository {

    suspend fun getTodayMatches(date: String): Flow<TodayMatchEntities.DomainMatchResponse>

}