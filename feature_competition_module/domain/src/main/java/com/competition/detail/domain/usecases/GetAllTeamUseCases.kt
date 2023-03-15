package com.competition.detail.domain.usecases

import com.competition.detail.domain.repo.TeamRepository
import com.project.room.model.RoomTeam
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTeamUseCases @Inject constructor (private val teamRepository: TeamRepository){

    fun getAllTeam(): Flow<List<RoomTeam>> {
        return teamRepository.getAllTeam()
    }

    suspend fun insertTeamList(id:Long){
        teamRepository.insertTeamList(id)
    }
}