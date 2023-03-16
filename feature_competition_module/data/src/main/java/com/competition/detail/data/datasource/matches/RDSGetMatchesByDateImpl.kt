package com.competition.detail.data.datasource.matches

import android.util.Log
import com.competition.detail.data.mapper.MatchesMapper
import com.project.network.hilt.api.ApiService
import com.project.room.FootballDao
import com.project.room.model.Match
import com.project.room.model.MatchesByDate
import kotlinx.coroutines.flow.Flow

class RDSGetMatchesByDateImpl(private val footballDao: FootballDao, private val apiService: ApiService):RDSGetMatchesByDate {
    override fun getMatchesByDate(): Flow<List<MatchesByDate>> = footballDao.getMatchesByDate()

    override suspend fun fetchMatchesByDateAndInsertIntoDB(id: Long, date: String) {
        val networkMatchList=apiService.getMatchesByCompetition(id,date,date).matches
        Log.i("====> ","$networkMatchList")
        footballDao.insertMatchesByDateList(MatchesMapper.convertToUserList(networkMatchList))
    }
}