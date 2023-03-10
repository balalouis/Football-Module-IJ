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
import com.project.presentation.uistate.AllMatchUiState
import com.project.presentation.adapter.MatchFixtureListAdapter
import com.project.presentation.databinding.FragmentMatchListBinding
import com.project.presentation.viewmodel.AllMatchViewModel
import com.project.room.model.Match
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MatchListFragment : Fragment() {

    private lateinit var binding: FragmentMatchListBinding
    private val loginViewModel: AllMatchViewModel by activityViewModels()

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
        loginViewModel.fetchMatchListAndInsertInDBVM()
        loginViewModel.getAllMatches()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                loginViewModel.allMatchUiState.collect {
                    when(it){
                        is AllMatchUiState.Success ->{
                            Log.i("=====> ","Success: "+it.matchList)
                            updateMatchListAdapter(it.matchList)
                        }
                        is AllMatchUiState.Failure -> {
                            Log.i("=====> ","Failure: ${it.exception}")
                        }
                        else -> {}
                    }
                }
            }
        }
    }

    private fun updateMatchListAdapter(matchList: List<Match>?) {
        val matchListAdapter = matchList?.let { context?.let { _ -> MatchFixtureListAdapter(it) } }
        val matchListRecyclerView = binding.fixturesRecyclerview
        matchListRecyclerView.adapter = matchListAdapter
        matchListRecyclerView.layoutManager = LinearLayoutManager(activity)
    }
}