package com.competition.detail.domain.repo

import com.project.room.model.Table
import kotlinx.coroutines.flow.Flow

interface TableRepository {
    fun getAllTables(): Flow<List<Table>>

    suspend fun insertTableList(id:Long)
}