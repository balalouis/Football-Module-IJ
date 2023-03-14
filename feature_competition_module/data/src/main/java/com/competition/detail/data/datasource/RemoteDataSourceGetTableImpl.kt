package com.competition.detail.data.datasource

import com.project.network.hilt.api.ApiService
import com.project.network.hilt.model.table.NetworkTableEntities
import com.project.room.FootballDao
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceGetTableImpl(private val footballDao: FootballDao, private val apiService: ApiService) :
    RemoteDataSourceGetTable {
    override fun getAllTable(): Flow<List<NetworkTableEntities.NetworkTable>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchTableListAndInsertIntoDB(id:Long) {
        val networkCompetitionsList=apiService.getTablesByCompetition(id,"TIER_ONE").standings
    }
}