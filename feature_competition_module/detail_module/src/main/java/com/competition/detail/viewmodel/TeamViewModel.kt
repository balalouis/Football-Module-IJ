package com.competition.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.competition.detail.domain.usecases.GetAllTeamUseCases
import com.competition.detail.uistate.RoomTeamUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TeamViewModel @Inject constructor(
    private val getAllTeamUseCases: GetAllTeamUseCases
) : ViewModel() {

    private val _allRoomTeamUiState = MutableStateFlow<RoomTeamUiState>(RoomTeamUiState.Success(
        emptyList()))
    val allRoomTeamUiState: StateFlow<RoomTeamUiState> = _allRoomTeamUiState

    fun getAllTeams(){
        viewModelScope.launch {
            getAllTeamUseCases.getAllTeam().catch {
                _allRoomTeamUiState.value = RoomTeamUiState.Failure(it)
            }.collect {
                _allRoomTeamUiState.value = RoomTeamUiState.Success(it)
            }
        }
    }

    fun fetchTeamListAndInsertInDBVM(id:Long){
        viewModelScope.launch {
            getAllTeamUseCases.insertTeamList(id)
        }
    }

}
