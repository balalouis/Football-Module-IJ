package com.competition.detail.domain.usecases

import com.competition.detail.domain.repo.TableRepository
import com.project.room.model.TableUiState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTableUseCases @Inject constructor (private val getAllMatchRepository: TableRepository){

    fun getAllTables(): Flow<TableUiState> {
        return getAllMatchRepository.getAllTables()
    }

    suspend fun insertTableList(id:Long){
        getAllMatchRepository.insertTableList(id)
    }
}