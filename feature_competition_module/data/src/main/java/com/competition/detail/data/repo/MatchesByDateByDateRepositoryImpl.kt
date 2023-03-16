package com.competition.detail.data.repo

import com.competition.detail.data.datasource.matches.RDSGetMatchesByDate
import com.competition.detail.domain.repo.MatchesByDateRepository
import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow

class MatchesByDateByDateRepositoryImpl(private val rdsGetMatchesByDate: RDSGetMatchesByDate) :
    MatchesByDateRepository {

    override fun getMatchesByDate(): Flow<List<Match>> = rdsGetMatchesByDate.getMatchesByDate()

    override suspend fun insertMatchesByDateList() {
        rdsGetMatchesByDate.fetchMatchesByDateAndInsertIntoDB()
    }

}