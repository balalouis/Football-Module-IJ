package com.project.football_module

import com.project.domain.model.TodayMatchEntities

sealed class CompetitionsUiState {
    data class Success(var domainMatchResponse: TodayMatchEntities.DomainMatchResponse?) : CompetitionsUiState()
    data class Failure(var exception: Throwable) : CompetitionsUiState()
}