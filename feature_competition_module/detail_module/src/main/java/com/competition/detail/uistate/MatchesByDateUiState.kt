package com.competition.detail.uistate

import com.project.room.model.Match

sealed class MatchesByDateUiState {
    data class Success(var matchList: List<Match>?) : MatchesByDateUiState()
    data class Failure(var exception: Throwable) : MatchesByDateUiState()
}