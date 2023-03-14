package com.competition.detail.domain.repo

import com.project.room.model.TableUiState
import kotlinx.coroutines.flow.Flow

interface TableRepository {
    fun getAllTables(): Flow<TableUiState>

    suspend fun insertTableList(id:Long)
}