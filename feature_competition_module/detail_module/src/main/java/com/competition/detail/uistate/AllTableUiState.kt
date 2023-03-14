package com.competition.detail.uistate

import com.project.room.model.Table

sealed class AllTableUiState {
    data class Success(var tableList: List<Table>?) : AllTableUiState()
    data class Failure(var exception: Throwable) : AllTableUiState()
}