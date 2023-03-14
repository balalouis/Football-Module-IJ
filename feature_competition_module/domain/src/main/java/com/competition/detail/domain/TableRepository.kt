package com.competition.detail.domain

import com.project.room.model.Standing
import kotlinx.coroutines.flow.Flow

interface TableRepository {
    fun getAllTables(): Flow<List<Standing>>

    suspend fun insertTableList()
}