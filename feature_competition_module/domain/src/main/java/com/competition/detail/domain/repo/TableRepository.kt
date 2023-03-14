package com.competition.detail.domain.repo

import com.project.room.model.Standing
import kotlinx.coroutines.flow.Flow

interface TableRepository {
    fun getAllTables(): Flow<List<Standing>>

    suspend fun insertTableList(id:Long)
}