package com.project.matchlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.domain.usecases.GetAllCompetitionUseCases
import com.project.matchlist.uistate.AllCompetitionUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllCompetitionViewModel @Inject constructor(
    private val getAllCompetitionUseCases: GetAllCompetitionUseCases
) : ViewModel() {

    private val _allCompetitionUiState = MutableStateFlow<AllCompetitionUiState>(
        AllCompetitionUiState.Success(
            emptyList()
        )
    )
    val allCompetitionUiState: StateFlow<AllCompetitionUiState> = _allCompetitionUiState

    fun getAllCompetition(){
        viewModelScope.launch {
            getAllCompetitionUseCases.getAllCompetition().catch {
                _allCompetitionUiState.value = AllCompetitionUiState.Failure(it)
            }.collect {
                _allCompetitionUiState.value = AllCompetitionUiState.Success(it)
            }
        }
    }

    fun fetchCompetitionListAndInsertInDBVM(){
        viewModelScope.launch {
            getAllCompetitionUseCases.insertCompetitionList()
        }
    }

}
