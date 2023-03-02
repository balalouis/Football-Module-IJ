package com.project.data.repository.datasource

import com.project.data.repository.api.ApiService
import com.project.domain.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(private val apiService: ApiService):RemoteDataSource {
    override suspend fun getAllMatches(date: String): Flow<TodayMatchEntities.DomainMatchResponse> =
        flow {
            emit(apiService.getAllMatches(date,date))
        }
}