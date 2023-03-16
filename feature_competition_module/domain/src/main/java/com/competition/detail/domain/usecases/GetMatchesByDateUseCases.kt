package com.competition.detail.domain.usecases

import com.competition.detail.domain.repo.MatchesByDateRepository
import com.project.room.model.Match
import com.project.room.model.MatchesByDate
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMatchesByDateUseCases @Inject constructor (private val getMatchesByDateRepository: MatchesByDateRepository){

    fun getMatchesByDate(): Flow<List<MatchesByDate>> {
        return getMatchesByDateRepository.getMatchesByDate()
    }

    suspend fun insertMatchesByDateList(id: Long, date: String){
        getMatchesByDateRepository.insertMatchesByDateList(id,date)
    }
}