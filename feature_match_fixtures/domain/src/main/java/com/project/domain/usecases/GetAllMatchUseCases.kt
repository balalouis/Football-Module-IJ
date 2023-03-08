package com.project.domain.usecases

import com.project.domain.repository.CompetitionsRepository
import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMatchUseCases @Inject constructor (private val competitionsRepository: CompetitionsRepository){

    fun getAllMatches(): Flow<List<Match>> {
        return competitionsRepository.getAllMatches()
    }

    suspend fun insertMatchList(){
        competitionsRepository.insertMatchList()
    }
}