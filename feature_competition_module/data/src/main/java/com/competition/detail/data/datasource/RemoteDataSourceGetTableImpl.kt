package com.competition.detail.data.datasource

import com.competition.detail.data.mapper.TeamMapper
import com.project.network.hilt.api.ApiService
import com.project.room.FootballDao
import com.project.room.model.Table
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceGetTableImpl(private val footballDao: FootballDao, private val apiService: ApiService) :
    RemoteDataSourceGetTable {

    override fun getAllTable(): Flow<List<Table>> = footballDao.getTableList()

    override suspend fun fetchTableListAndInsertIntoDB(id:Long) {
        val networkStandingList=apiService.getTablesByCompetition(id,"TOTAL").standings
        footballDao.insertTableList(tableList = TeamMapper.convertToTeamList(networkStandingList))
    }
}