package com.project.domain.usecases

import com.project.domain.repository.GetAllMatchesRepository
import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMatchUseCases @Inject constructor (private val getAllMatchesRepository: GetAllMatchesRepository){

    fun getAllMatches(): Flow<List<Match>> {
        return getAllMatchesRepository.getAllMatches()
    }

    suspend fun insertMatchList(){
        getAllMatchesRepository.insertMatchList()
    }
}