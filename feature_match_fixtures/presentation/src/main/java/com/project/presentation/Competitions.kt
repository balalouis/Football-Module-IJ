package com.project.presentation

import com.project.network.hilt.model.TodayMatchEntities


sealed class CompetitionsUiState {
    data class Success(var networkMatchResponse: TodayMatchEntities.NetworkMatchResponse?) : CompetitionsUiState()
    data class Failure(var exception: Throwable) : CompetitionsUiState()
}