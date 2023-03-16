package com.competition.detail.data.datasource.matches

import android.util.Log
import com.competition.detail.data.mapper.MatchesMapper
import com.project.network.hilt.api.ApiService
import com.project.room.FootballDao
import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow

class RDSGetMatchesByDateImpl(private val footballDao: FootballDao, private val apiService: ApiService):RDSGetMatchesByDate {
    override fun getMatchesByDate(): Flow<List<Match>> = footballDao.getAllMatch()

    override suspend fun fetchMatchesByDateAndInsertIntoDB() {
        val networkMatchList=apiService.getAllMatches().matches
        Log.i("====> ","$networkMatchList")
        footballDao.insertMatchList(MatchesMapper.convertToUserList(networkMatchList))
    }
}