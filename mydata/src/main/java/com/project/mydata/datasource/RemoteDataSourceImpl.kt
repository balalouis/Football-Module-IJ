package com.project.mydata.datasource

import com.project.network.hilt.api.ApiService
import com.project.network.hilt.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(private val apiService: ApiService):RemoteDataSource {
    override suspend fun getAllMatches(): Flow<TodayMatchEntities.DomainMatchResponse> =
        flow {
            emit(apiService.getAllMatches())
        }
}