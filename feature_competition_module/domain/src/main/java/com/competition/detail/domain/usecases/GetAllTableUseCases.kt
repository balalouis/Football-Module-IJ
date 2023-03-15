package com.competition.detail.domain.usecases

import com.competition.detail.domain.repo.TableRepository
import com.project.room.model.Table
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTableUseCases @Inject constructor (private val tableRepository: TableRepository){

    fun getAllTables(): Flow<List<Table>> {
        return tableRepository.getAllTables()
    }

    suspend fun insertTableList(id:Long){
        tableRepository.insertTableList(id)
    }
}