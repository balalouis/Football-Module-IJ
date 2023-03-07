package com.project.mydomain.usecases

import com.project.mydomain.repository.CompetitionsRepository
import com.project.network.hilt.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMatchUseCases @Inject constructor (private val competitionsRepository: CompetitionsRepository){

    suspend fun getAllMatches(): Flow<TodayMatchEntities.DomainMatchResponse> {
        return competitionsRepository.getAllMatches()
    }

}