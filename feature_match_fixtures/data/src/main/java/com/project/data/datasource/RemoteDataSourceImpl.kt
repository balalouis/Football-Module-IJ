package com.project.data.datasource

import com.project.network.hilt.api.ApiService
import com.project.network.hilt.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(private val apiService: ApiService):RemoteDataSource {
    override suspend fun getAllMatches(): Flow<TodayMatchEntities.NetworkMatchResponse> =
        flow {
            emit(apiService.getAllMatches())
        }
}