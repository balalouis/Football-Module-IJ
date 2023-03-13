package com.project.matchlist.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.project.domain.usecases.GetAllMatchUseCases
import com.project.matchlist.uistate.AllMatchUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AllMatchViewModel @Inject constructor(
    private val getAllMatchUseCases: GetAllMatchUseCases
) : ViewModel() {

    private val _allMatchUiState = MutableStateFlow<AllMatchUiState>(
        AllMatchUiState.Success(
            emptyList()
        )
    )
    val allMatchUiState: StateFlow<AllMatchUiState> = _allMatchUiState

    fun getAllMatches(){
        viewModelScope.launch {
            getAllMatchUseCases.getAllMatches().catch {
                _allMatchUiState.value = AllMatchUiState.Failure(it)
            }.collect {
                _allMatchUiState.value = AllMatchUiState.Success(it)
            }
        }
    }

    fun fetchMatchListAndInsertInDBVM(){
        viewModelScope.launch {
            getAllMatchUseCases.insertMatchList()
        }
    }

}
