package com.project.presentation

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
import com.project.network.hilt.model.TodayMatchEntities
import com.project.presentation.adapter.MatchFixtureListAdapter
import com.project.presentation.databinding.FragmentMatchListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MatchListFragment : Fragment() {

    private lateinit var binding: FragmentMatchListBinding
    private val loginViewModel: CompetitionsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requestAllMatches()
    }

    private fun requestAllMatches(){
        loginViewModel.getAllMatches()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                loginViewModel.allMatchUiState.collect {
                    when(it){
                        is CompetitionsUiState.Success ->{
//                            Log.i("=====> ","${it.domainMatchResponse?.matches}")
                            updateMatchListAdapter(it.domainMatchResponse?.matches)
                        }
                        is CompetitionsUiState.Failure -> {
                            Log.i("=====> ","Failure: ${it.exception}")
                        }
                    }
                }
            }
        }
    }

    private fun updateMatchListAdapter(matchList: List<TodayMatchEntities.NetworkMatch>?) {
        val matchListAdapter = matchList?.let { context?.let { _ -> MatchFixtureListAdapter(it) } }
        val matchListRecyclerView = binding.fixturesRecyclerview
        matchListRecyclerView.adapter = matchListAdapter
        matchListRecyclerView.layoutManager = LinearLayoutManager(activity)
    }
}