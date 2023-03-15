package com.competition.detail.uistate

import com.project.room.model.RoomTeam

sealed class RoomTeamUiState {
    data class Success(var teamList: List<RoomTeam>?) : RoomTeamUiState()
    data class Failure(var exception: Throwable) : RoomTeamUiState()
}