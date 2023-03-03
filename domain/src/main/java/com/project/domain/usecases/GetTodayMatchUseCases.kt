package com.project.domain.usecases

import com.project.domain.model.TodayMatchEntities
import com.project.domain.repository.CompetitionsRepository
import kotlinx.coroutines.flow.Flow

class GetTodayMatchUseCases (private val competitionsRepository: CompetitionsRepository){

    suspend fun getTodayMatches(input: String?): Flow<TodayMatchEntities.DomainMatchResponse> {
        return competitionsRepository.getTodayMatches(input.toString())
    }

}