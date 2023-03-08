package com.project.data.datasource

import com.project.network.hilt.model.TodayMatchEntities
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getAllMatches(): Flow<TodayMatchEntities.NetworkMatchResponse>

}