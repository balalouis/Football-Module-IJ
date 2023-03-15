package com.competition.detail.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.competition.detail.adapter.TeamListAdapter
import com.competition.detail.databinding.FragmentTeamBinding
import com.competition.detail.uistate.RoomTeamUiState
import com.competition.detail.viewmodel.TeamViewModel
import com.project.room.model.RoomTeam
import kotlinx.coroutines.launch

class TeamFragment : Fragment() {

    private lateinit var binding: FragmentTeamBinding
    private val teamViewModel: TeamViewModel by activityViewModels()
    var competitionId: Long = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTeamBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getIntents()
        requestTeam()
    }

    private fun getIntents() {
        competitionId = arguments?.getLong("id")!!
    }

    private fun requestTeam(){
        teamViewModel.fetchTeamListAndInsertInDBVM(competitionId)
        teamViewModel.getAllTeams()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                teamViewModel.allRoomTeamUiState.collect {
                    when(it){
                        is RoomTeamUiState.Success ->{
                            if(it.teamList?.size!! > 0) {
                                updateTeamListAdapter(it.teamList)
                            }
                        }
                        is RoomTeamUiState.Failure -> {
                            Log.i("=====> ","Failure: ${it.exception}")
                        }
                    }
                }
            }
        }
    }

    private fun updateTeamListAdapter(teamRoomList: List<RoomTeam>?) {
        val teamListAdapter = teamRoomList?.let { context?.let { _ -> TeamListAdapter(it) } }
        val teamListRecyclerView = binding.teamRecyclerview
        teamListRecyclerView.adapter = teamListAdapter
        teamListRecyclerView.layoutManager = LinearLayoutManager(activity)
    }
}