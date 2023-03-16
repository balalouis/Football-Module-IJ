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
import androidx.recyclerview.widget.GridLayoutManager
import com.competition.detail.adapter.FixtureListAdapter
import com.competition.detail.databinding.FragmentFixturesBinding
import com.competition.detail.uistate.MatchesByDateUiState
import com.competition.detail.utils.Utilities
import com.competition.detail.viewmodel.FixtureViewModel
import com.project.room.model.MatchesByDate
import kotlinx.coroutines.launch

class FixturesFragment : Fragment() {

    private lateinit var binding: FragmentFixturesBinding
    private val fixtureViewModel: FixtureViewModel by activityViewModels()
    var competitionId: Long = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFixturesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getIntents()
        requestFixture()
    }

    private fun getIntents() {
        competitionId = arguments?.getLong("id")!!
    }

    private fun requestFixture(){
        fixtureViewModel.fetchMatchesByDateListAndInsertInDBVM(competitionId, Utilities.getCurrentDate())
        fixtureViewModel.getMatchesByDate()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                fixtureViewModel.matchesByDateUiState.collect {
                    when(it){
                        is MatchesByDateUiState.Success ->{
                            if(it.matchList?.size!! > 0) {
                                updateFixtureListAdapter(it.matchList)
                            }
                        }
                        is MatchesByDateUiState.Failure -> {
                            Log.i("=====> ","Failure: ${it.exception}")
                        }
                    }
                }
            }
        }
    }

    private fun updateFixtureListAdapter(matchesByDateList: List<MatchesByDate>?) {
        val fixtureListAdapter = matchesByDateList?.let { context?.let { _ -> FixtureListAdapter(it) } }
        val fixtureListRecyclerView = binding.fixtureRecyclerview
        fixtureListRecyclerView.adapter = fixtureListAdapter
        fixtureListRecyclerView.layoutManager = GridLayoutManager(activity,2)
    }
}