package com.project.mydomain.usecases

import com.project.mydomain.model.TodayMatchEntities
import com.project.mydomain.repository.CompetitionsRepository
import kotlinx.coroutines.flow.Flow

class GetTodayMatchUseCases (private val competitionsRepository: CompetitionsRepository){

    suspend fun getTodayMatches(input: String?): Flow<TodayMatchEntities.DomainMatchResponse> {
        return competitionsRepository.getTodayMatches(input.toString())
    }

}