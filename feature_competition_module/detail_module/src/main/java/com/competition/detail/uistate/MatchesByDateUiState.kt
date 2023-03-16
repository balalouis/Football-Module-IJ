package com.competition.detail.uistate

import com.project.room.model.MatchesByDate

sealed class MatchesByDateUiState {
    data class Success(var matchList: List<MatchesByDate>?) : MatchesByDateUiState()
    data class Failure(var exception: Throwable) : MatchesByDateUiState()
}