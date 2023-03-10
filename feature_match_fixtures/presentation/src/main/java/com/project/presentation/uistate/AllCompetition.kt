package com.project.presentation.uistate

import com.project.room.model.CompetitionsUiState

sealed class AllCompetitionUiState {
    data class Success(var competitionsUiStateList: List<CompetitionsUiState>?) : AllCompetitionUiState()
    data class Failure(var exception: Throwable) : AllCompetitionUiState()
}