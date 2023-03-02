package com.project.data.repository.datasource

import com.project.domain.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getAllMatches(date: String): Flow<TodayMatchEntities.DomainMatchResponse>

}