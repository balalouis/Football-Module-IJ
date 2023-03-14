package com.competition.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.competition.detail.domain.usecases.GetAllTableUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TableViewModel @Inject constructor(
    private val getAllTableUseCases: GetAllTableUseCases
) : ViewModel() {

   /* private val _allMatchUiState = MutableStateFlow<AllMatchUiState>(
        AllMatchUiState.Success(
            emptyList()
        )
    )
    val allMatchUiState: StateFlow<AllMatchUiState> = _allMatchUiState*/

    fun getAllTables(){
        /*viewModelScope.launch {
            getAllTableUseCases.getAllTables().catch {
                _allMatchUiState.value = AllMatchUiState.Failure(it)
            }.collect {
                _allMatchUiState.value = AllMatchUiState.Success(it)
            }
        }*/
    }

    fun fetchMatchListAndInsertInDBVM(id:Long){
        viewModelScope.launch {
            getAllTableUseCases.insertTableList(id)
        }
    }

}
