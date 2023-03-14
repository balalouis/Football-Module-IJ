package com.competition.detail.data.datasource

import android.util.Log
import com.competition.detail.data.mapper.TeamMapper
import com.project.network.hilt.api.ApiService
import com.project.room.FootballDao
import com.project.room.model.Standing
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceGetTableImpl(private val footballDao: FootballDao, private val apiService: ApiService) :
    RemoteDataSourceGetTable {
    override fun getAllTable(): Flow<List<Standing>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchTableListAndInsertIntoDB(id:Long) {
        val networkStandingList=apiService.getTablesByCompetition(id,"TOTAL").standings
        val teamList=TeamMapper.convertToTeamList(networkStandingList)
        Log.i("====> ","${teamList.size}")
    }
}