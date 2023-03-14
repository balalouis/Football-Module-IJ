package com.competition.detail.data.datasource

import com.project.room.model.TableUiState
import kotlinx.coroutines.flow.Flow

interface RemoteDataSourceGetTable {
    fun getAllTable(): Flow<TableUiState>

    suspend fun fetchTableListAndInsertIntoDB(id:Long)
}