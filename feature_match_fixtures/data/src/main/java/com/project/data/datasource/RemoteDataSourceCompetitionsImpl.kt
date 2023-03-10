package com.project.data.datasource

import com.project.data.mapper.MatchListMapper
import com.project.network.hilt.api.ApiService
import com.project.room.FootballDao
import com.project.room.model.CompetitionsUiState
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceCompetitionsImpl(private val footballDao: FootballDao, private val apiService: ApiService) : RemoteDataSourceCompetitions {
    override fun getAllCompetitions(): Flow<List<CompetitionsUiState>> =
        footballDao.getAllCompetitions()

    override suspend fun fetchAllCompetitionsAndInsertIntoDB() {
        val networkCompetitionsList=apiService.getAllCompetitions("TIER_ONE").competitions
        footballDao.insertCompetitionList(MatchListMapper.convertToCompetitionList(networkCompetitionsList))
    }
}