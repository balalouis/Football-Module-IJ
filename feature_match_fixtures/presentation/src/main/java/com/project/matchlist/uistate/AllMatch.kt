package com.project.matchlist.uistate

import com.project.room.model.Match

sealed class AllMatchUiState {
    data class Success(var matchList: List<Match>?) : AllMatchUiState()
    data class Failure(var exception: Throwable) : AllMatchUiState()
}