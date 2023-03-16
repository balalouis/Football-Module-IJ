package com.competition.detail.data.datasource.team

import android.util.Log
import com.competition.detail.data.mapper.TeamMapper
import com.project.network.hilt.api.ApiService
import com.project.room.FootballDao
import com.project.room.model.RoomTeam
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceGetTeamImpl(private val footballDao: FootballDao, private val apiService: ApiService) :
    RemoteDataSourceGetTeam {

    override fun getAllTeam(): Flow<List<RoomTeam>> = footballDao.getRoomTeamList()

    override suspend fun fetchTableListAndInsertIntoDB(id:Long) {
        val networkTeamList=apiService.getTeamsByCompetition(id).teams
        footballDao.insertRoomTeamList(roomTeamList = TeamMapper.convertToRoomTeamList(networkTeamList))
    }
}