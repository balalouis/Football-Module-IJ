package com.competition.detail.domain.usecases

import com.competition.detail.domain.repo.MatchesByDateRepository
import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMatchesByDateUseCases @Inject constructor (private val getMatchesByDateRepository: MatchesByDateRepository){

    fun getMatchesByDate(): Flow<List<Match>> {
        return getMatchesByDateRepository.getMatchesByDate()
    }

    suspend fun insertMatchesByDateList(){
        getMatchesByDateRepository.insertMatchesByDateList()
    }
}