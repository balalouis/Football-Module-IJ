package com.competition.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.competition.detail.domain.usecases.GetAllTableUseCases
import com.competition.detail.uistate.AllTableUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TableViewModel @Inject constructor(
    private val getAllTableUseCases: GetAllTableUseCases
) : ViewModel() {

    private val _allTableUiState = MutableStateFlow<AllTableUiState>(AllTableUiState.Success(
        emptyList()))
    val allTableUiState: StateFlow<AllTableUiState> = _allTableUiState

    fun getAllTables(){
        viewModelScope.launch {
            getAllTableUseCases.getAllTables().catch {
                _allTableUiState.value = AllTableUiState.Failure(it)
            }.collect {
                _allTableUiState.value = AllTableUiState.Success(it.table)
            }
        }
    }

    fun fetchMatchListAndInsertInDBVM(id:Long){
        viewModelScope.launch {
            getAllTableUseCases.insertTableList(id)
        }
    }

}
