package com.project.presentation.ui

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
import com.project.presentation.adapter.CompetitionListAdapter
import com.project.presentation.databinding.FragmentCompetitionListBinding
import com.project.presentation.uistate.AllCompetitionUiState
import com.project.presentation.viewmodel.AllCompetitionViewModel
import com.project.room.model.CompetitionsUiState
import kotlinx.coroutines.launch

class CompetitionListFragment : Fragment() {

    private lateinit var binding: FragmentCompetitionListBinding
    private val viewModel: AllCompetitionViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCompetitionListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestAllCompetition()
    }

    private fun requestAllCompetition(){
        viewModel.fetchCompetitionListAndInsertInDBVM()
        viewModel.getAllCompetition()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.allCompetitionUiState.collect {
                    when(it){
                        is AllCompetitionUiState.Success ->{
                            Log.i("=====> ","Success: "+it.competitionsUiStateList)
                            updateCompetitionListAdapter(it.competitionsUiStateList)
                        }
                        is AllCompetitionUiState.Failure -> {
                            Log.i("=====> ","Failure: ${it.exception}")
                        }
                    }
                }
            }
        }
    }

    private fun updateCompetitionListAdapter(competitionsUiStateList: List<CompetitionsUiState>?) {
        val competitionListAdapter = competitionsUiStateList?.let { context?.let { _ -> CompetitionListAdapter(it) } }
        val matchListRecyclerView = binding.competitionRecyclerview
        matchListRecyclerView.adapter = competitionListAdapter
        matchListRecyclerView.layoutManager = LinearLayoutManager(activity)
    }
}