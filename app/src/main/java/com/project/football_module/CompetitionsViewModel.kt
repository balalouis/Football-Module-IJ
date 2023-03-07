package com.project.football_module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.mydomain.usecases.GetTodayMatchUseCases
import com.project.network.hilt.model.TodayMatchEntities
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompetitionsViewModel @Inject constructor(
    private val getTodayFixturesUseCase: GetTodayMatchUseCases
) : ViewModel() {

    private val _todayMatchUiState = MutableStateFlow<CompetitionsUiState>(CompetitionsUiState.Success(
        TodayMatchEntities.DomainMatchResponse()))
    val todayMatchUiState: StateFlow<CompetitionsUiState> = _todayMatchUiState

    fun getTodayMatches(date: String){
        viewModelScope.launch {
            getTodayFixturesUseCase.getTodayMatches(date).catch {
                _todayMatchUiState.value = CompetitionsUiState.Failure(it)
            }.collect {
                _todayMatchUiState.value = CompetitionsUiState.Success(it)
            }
        }
    }

}
