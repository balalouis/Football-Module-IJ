package com.competition.detail.data.datasource.team

import com.project.room.model.RoomTeam
import kotlinx.coroutines.flow.Flow

interface RemoteDataSourceGetTeam {
    fun getAllTeam(): Flow<List<RoomTeam>>

    suspend fun fetchTableListAndInsertIntoDB(id:Long)
}