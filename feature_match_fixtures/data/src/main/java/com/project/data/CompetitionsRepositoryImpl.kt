package com.project.data

import com.project.data.datasource.RemoteDataSource
import com.project.domain.repository.CompetitionsRepository
import com.project.network.hilt.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow

class CompetitionsRepositoryImpl(private val remoteDataSource: RemoteDataSource) :
    CompetitionsRepository {

    override suspend fun getAllMatches(): Flow<TodayMatchEntities.DomainMatchResponse> =
        remoteDataSource.getAllMatches()

}