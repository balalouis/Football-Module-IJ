package com.project.data.repository

import com.project.domain.model.TodayMatchEntities
import com.project.domain.repository.CompetitionsRepository

class CompetitionsRepositoryImpl :CompetitionsRepository {
    override suspend fun getTodayMatches(date: String): TodayMatchEntities.DomainMatchResponse {
        TODO("Not yet implemented")
    }
}