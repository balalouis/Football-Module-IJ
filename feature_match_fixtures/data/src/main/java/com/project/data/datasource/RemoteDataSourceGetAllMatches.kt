package com.project.data.datasource

import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow

interface RemoteDataSourceGetAllMatches {

    fun getAllMatches(): Flow<List<Match>>

    suspend fun fetchMatchListAndInsertIntoDB()

}