package com.competition.detail.domain.repo

import com.project.room.model.RoomTeam
import kotlinx.coroutines.flow.Flow

interface TeamRepository {
    fun getAllTeam(): Flow<List<RoomTeam>>

    suspend fun insertTeamList(id:Long)
}