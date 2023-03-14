package com.competition.detail.data.datasource

import com.project.room.model.Standing
import kotlinx.coroutines.flow.Flow

interface RemoteDataSourceGetTable {
    fun getAllTable(): Flow<List<Standing>>

    suspend fun fetchTableListAndInsertIntoDB(id:Long)
}