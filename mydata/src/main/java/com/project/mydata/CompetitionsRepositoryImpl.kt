package com.project.mydata

import com.project.mydata.datasource.RemoteDataSource
import com.project.mydomain.model.TodayMatchEntities
import com.project.mydomain.repository.CompetitionsRepository
import kotlinx.coroutines.flow.Flow

class CompetitionsRepositoryImpl(private val remoteDataSource: RemoteDataSource) :
    CompetitionsRepository {

    override suspend fun getTodayMatches(date: String): Flow<TodayMatchEntities.DomainMatchResponse> =
        remoteDataSource.getAllMatches(date)

}