package com.project.mydata.datasource

import com.project.mydomain.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getAllMatches(date: String): Flow<TodayMatchEntities.DomainMatchResponse>

}