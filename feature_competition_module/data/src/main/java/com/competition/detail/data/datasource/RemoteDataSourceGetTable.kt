package com.competition.detail.data.datasource

import com.project.network.hilt.model.table.NetworkTableEntities
import kotlinx.coroutines.flow.Flow

interface RemoteDataSourceGetTable {
    fun getAllTable(): Flow<List<NetworkTableEntities.NetworkTable>>

    suspend fun fetchTableListAndInsertIntoDB(id:Long)
}