package com.project.data.repo

import com.project.data.datasource.RemoteDataSourceCompetitions
import com.project.domain.repository.GetAllCompetitionRepository
import com.project.room.model.CompetitionsUiState
import kotlinx.coroutines.flow.Flow

class GetAllCompetitionRepositoryImpl(private val remoteDataSourceCompetitions: RemoteDataSourceCompetitions):GetAllCompetitionRepository {
    override fun getAllCompetitions(): Flow<List<CompetitionsUiState>> =
        remoteDataSourceCompetitions.getAllCompetitions()

    override suspend fun insertAllCompetitions() =
        remoteDataSourceCompetitions.fetchAllCompetitionsAndInsertIntoDB()

}