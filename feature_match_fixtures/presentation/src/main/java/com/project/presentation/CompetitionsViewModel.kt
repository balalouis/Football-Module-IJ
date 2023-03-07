package com.project.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.domain.usecases.GetAllMatchUseCases
import com.project.network.hilt.model.TodayMatchEntities
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompetitionsViewModel @Inject constructor(
    private val getAllMatchUseCases: GetAllMatchUseCases
) : ViewModel() {

    private val _allMatchUiState = MutableStateFlow<CompetitionsUiState>(CompetitionsUiState.Success(
        TodayMatchEntities.DomainMatchResponse()))
    val allMatchUiState: StateFlow<CompetitionsUiState> = _allMatchUiState

    fun getAllMatches(){
        viewModelScope.launch {
            getAllMatchUseCases.getAllMatches().catch {
                _allMatchUiState.value = CompetitionsUiState.Failure(it)
            }.collect {
                _allMatchUiState.value = CompetitionsUiState.Success(it)
            }
        }
    }

}