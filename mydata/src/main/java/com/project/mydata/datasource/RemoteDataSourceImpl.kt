package com.project.mydata.datasource

import com.project.mydata.api.ApiService
import com.project.mydomain.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl(private val apiService: ApiService):RemoteDataSource {
    override suspend fun getAllMatches(date: String): Flow<TodayMatchEntities.DomainMatchResponse> =
        flow {
            emit(apiService.getAllMatches(date,date))
        }
}