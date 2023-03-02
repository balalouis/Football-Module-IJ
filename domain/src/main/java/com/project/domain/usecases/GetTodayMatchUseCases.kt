package com.project.domain.usecases

import com.project.domain.model.TodayMatchEntities
import com.project.domain.repository.CompetitionsRepository

class GetTodayMatchUseCases (private val competitionsRepository: CompetitionsRepository){

    suspend operator fun invoke(input: String?): TodayMatchEntities.DomainMatchResponse {
        return competitionsRepository.getTodayMatches(input.toString())
    }

}