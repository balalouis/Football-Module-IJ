package com.competition.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.competition.detail.domain.usecases.GetMatchesByDateUseCases
import com.competition.detail.uistate.MatchesByDateUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixtureViewModel @Inject constructor(
    private val getMatchesByDateUseCases: GetMatchesByDateUseCases
) : ViewModel() {

    private val _allMatchesByDateUiState = MutableStateFlow<MatchesByDateUiState>(
        MatchesByDateUiState.Success(
            emptyList()
        )
    )
    val matchesByDateUiState: StateFlow<MatchesByDateUiState> = _allMatchesByDateUiState

    fun getMatchesByDate(){
        viewModelScope.launch {
            getMatchesByDateUseCases.getMatchesByDate().catch {
                _allMatchesByDateUiState.value = MatchesByDateUiState.Failure(it)
            }.collect {
                _allMatchesByDateUiState.value = MatchesByDateUiState.Success(it)
            }
        }
    }

    fun fetchMatchesByDateListAndInsertInDBVM(id: Long, date: String){
        viewModelScope.launch {
            getMatchesByDateUseCases.insertMatchesByDateList(id,date)
        }
    }

}
