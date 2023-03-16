package com.project.data.datasource

import android.util.Log
import com.project.data.mapper.MatchListMapper
import com.project.network.hilt.api.ApiService
import com.project.room.FootballDao
import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow

class RemoteDataSourceGetAllMatchesImpl(private val footballDao: FootballDao, private val apiService: ApiService):RemoteDataSourceGetAllMatches {
    override fun getAllMatches(): Flow<List<Match>> = footballDao.getAllMatch()

    override suspend fun fetchMatchListAndInsertIntoDB() {
        val networkMatchList=apiService.getAllMatches().matches
        footballDao.insertMatchList(MatchListMapper.convertToUserList(networkMatchList))
    }
}