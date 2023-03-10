package com.project.data.datasource

import android.util.Log
import com.project.network.hilt.api.ApiService
import com.project.network.hilt.model.competitions.CompetitionsEntities
import com.project.room.FootballDao
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceCompetitionsImpl(val footballDao: FootballDao,val apiService: ApiService) : RemoteDataSourceCompetitions {
    override fun getAllCompetitions(): Flow<List<CompetitionsEntities.Competition>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchAllCompetitionsAndInsertIntoDB() {
        val networkCompetitionsList=apiService.getAllCompetitions("TIER_ONE")
        Log.i("====> ","$networkCompetitionsList")
    }
}