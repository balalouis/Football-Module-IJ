package com.project.presentation.uistate

import com.project.room.model.Competitions

sealed class AllCompetitionUiState {
    data class Success(var competitionsList: List<Competitions>?) : AllCompetitionUiState()
    data class Failure(var exception: Throwable) : AllCompetitionUiState()
}