package com.project.data.repo

import com.project.data.datasource.RemoteDataSourceGetAllMatches
import com.project.domain.repository.GetAllMatchesRepository
import com.project.room.model.Match
import kotlinx.coroutines.flow.Flow

class GetAllMatchesRepositoryImpl(private val remoteDataSourceGetAllMatches: RemoteDataSourceGetAllMatches) :
    GetAllMatchesRepository {

    override fun getAllMatches(): Flow<List<Match>> =
        remoteDataSourceGetAllMatches.getAllMatches()

    override suspend fun insertMatchList() {
        remoteDataSourceGetAllMatches.fetchMatchListAndInsertIntoDB()
    }

}