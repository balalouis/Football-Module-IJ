package com.project.domain.repository

import com.project.domain.model.TodayMatchEntities

interface CompetitionsRepository {

    suspend fun getTodayMatches(date: String): TodayMatchEntities.DomainMatchResponse

}