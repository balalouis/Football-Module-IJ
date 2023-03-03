package com.project.data.repository

import com.project.data.repository.datasource.RemoteDataSource
import com.project.domain.model.TodayMatchEntities
import com.project.domain.repository.CompetitionsRepository
import kotlinx.coroutines.flow.Flow

class CompetitionsRepositoryImpl(private val remoteDataSource: RemoteDataSource) :CompetitionsRepository {

    override suspend fun getTodayMatches(date: String): Flow<TodayMatchEntities.DomainMatchResponse> =
        remoteDataSource.getAllMatches(date)

}