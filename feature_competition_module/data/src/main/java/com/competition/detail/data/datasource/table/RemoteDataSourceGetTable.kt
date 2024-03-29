package com.competition.detail.data.datasource.table

import com.project.room.model.Table
import kotlinx.coroutines.flow.Flow

interface RemoteDataSourceGetTable {
    fun getAllTable(): Flow<List<Table>>

    suspend fun fetchTableListAndInsertIntoDB(id:Long)
}