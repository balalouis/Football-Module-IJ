package com.project.presentation

import com.project.network.hilt.model.TodayMatchEntities


sealed class CompetitionsUiState {
    data class Success(var domainMatchResponse: TodayMatchEntities.DomainMatchResponse?) : CompetitionsUiState()
    data class Failure(var exception: Throwable) : CompetitionsUiState()
}