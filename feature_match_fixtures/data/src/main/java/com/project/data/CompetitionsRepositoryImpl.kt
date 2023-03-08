package com.project.data

import com.project.data.datasource.RemoteDataSource
import com.project.domain.repository.CompetitionsRepository
import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow

class CompetitionsRepositoryImpl(private val remoteDataSource: RemoteDataSource) :
    CompetitionsRepository {

    override fun getAllMatches(): Flow<List<Match>> =
        remoteDataSource.getAllMatches()

    override suspend fun insertMatchList() {
        remoteDataSource.fetchMatchListAndInsertIntoDB()
    }

}