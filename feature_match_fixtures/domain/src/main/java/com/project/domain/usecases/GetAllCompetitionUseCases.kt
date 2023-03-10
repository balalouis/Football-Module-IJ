package com.project.domain.usecases

import com.project.domain.repository.GetAllCompetitionRepository
import com.project.room.model.CompetitionsUiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCompetitionUseCases @Inject constructor(private val getAllCompetitionRepository: GetAllCompetitionRepository) {

    fun getAllCompetition(): Flow<List<CompetitionsUiState>> =
        getAllCompetitionRepository.getAllCompetitions()

    suspend fun insertCompetitionList() =
        getAllCompetitionRepository.insertAllCompetitions()

}