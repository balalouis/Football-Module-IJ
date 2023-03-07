package com.project.mydata.datasource

import com.project.network.hilt.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getAllMatches(date: String): Flow<TodayMatchEntities.DomainMatchResponse>

}