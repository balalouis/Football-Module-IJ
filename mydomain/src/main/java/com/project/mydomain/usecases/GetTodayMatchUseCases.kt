package com.project.mydomain.usecases

import com.project.mydomain.repository.CompetitionsRepository
import com.project.network.hilt.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTodayMatchUseCases @Inject constructor (private val competitionsRepository: CompetitionsRepository){

    suspend fun getTodayMatches(input: String?): Flow<TodayMatchEntities.DomainMatchResponse> {
        return competitionsRepository.getTodayMatches(input.toString())
    }

}