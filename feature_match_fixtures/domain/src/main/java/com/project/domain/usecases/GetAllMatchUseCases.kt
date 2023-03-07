package com.project.domain.usecases

import com.project.domain.repository.CompetitionsRepository
import com.project.network.hilt.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMatchUseCases @Inject constructor (private val competitionsRepository: CompetitionsRepository){

    suspend fun getAllMatches(): Flow<TodayMatchEntities.DomainMatchResponse> {
        return competitionsRepository.getAllMatches()
    }

}