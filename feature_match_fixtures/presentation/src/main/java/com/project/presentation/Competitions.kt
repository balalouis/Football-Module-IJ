package com.project.presentation

import com.project.room.model.Match


sealed class CompetitionsUiState {
    data class Success(var matchList: List<Match>?) : CompetitionsUiState()
    data class Failure(var exception: Throwable) : CompetitionsUiState()
}