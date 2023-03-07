package com.project.mydata

import com.project.mydata.datasource.RemoteDataSource
import com.project.mydomain.repository.CompetitionsRepository
import com.project.network.hilt.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow

class CompetitionsRepositoryImpl(private val remoteDataSource: RemoteDataSource) :
    CompetitionsRepository {

    override suspend fun getAllMatches(): Flow<TodayMatchEntities.DomainMatchResponse> =
        remoteDataSource.getAllMatches()

}