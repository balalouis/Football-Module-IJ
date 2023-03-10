package com.project.data.repo

import com.project.data.datasource.RemoteDataSourceCompetitions
import com.project.domain.repository.GetAllCompetitionRepository
import com.project.room.model.Competitions
import kotlinx.coroutines.flow.Flow

class GetAllCompetitionRepositoryImpl(private val remoteDataSourceCompetitions: RemoteDataSourceCompetitions):GetAllCompetitionRepository {
    override fun getAllCompetitions(): Flow<List<Competitions>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertAllCompetitions() {
        remoteDataSourceCompetitions.fetchAllCompetitionsAndInsertIntoDB()
    }
}