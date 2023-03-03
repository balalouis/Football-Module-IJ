package com.project.domain.repository

import com.project.domain.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepository {

    suspend fun getTodayMatches(date: String): Flow<TodayMatchEntities.DomainMatchResponse>

}