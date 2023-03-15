package com.competition.detail.data.repo

import com.competition.detail.data.datasource.team.RemoteDataSourceGetTeam
import com.competition.detail.domain.repo.TeamRepository
import com.project.room.model.RoomTeam
import kotlinx.coroutines.flow.Flow

class TeamRepositoryImpl(private val remoteDataSourceGetTeam: RemoteDataSourceGetTeam):
    TeamRepository {

    override fun getAllTeam(): Flow<List<RoomTeam>> = remoteDataSourceGetTeam.getAllTeam()

    override suspend fun insertTeamList(id: Long) {
        remoteDataSourceGetTeam.fetchTableListAndInsertIntoDB(id)
    }
}