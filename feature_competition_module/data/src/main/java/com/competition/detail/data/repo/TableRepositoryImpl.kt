package com.competition.detail.data.repo

import com.competition.detail.data.datasource.RemoteDataSourceGetTable
import com.competition.detail.domain.repo.TableRepository
import com.project.room.model.TableUiState
import kotlinx.coroutines.flow.Flow

class TableRepositoryImpl(private val remoteDataSourceGetTable: RemoteDataSourceGetTable):
    TableRepository {
    override fun getAllTables(): Flow<TableUiState> =
        remoteDataSourceGetTable.getAllTable()


    override suspend fun insertTableList(id:Long) {
        remoteDataSourceGetTable.fetchTableListAndInsertIntoDB(id)
    }
}