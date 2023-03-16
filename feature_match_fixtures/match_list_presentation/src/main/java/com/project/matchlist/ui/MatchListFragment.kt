package com.project.matchlist.ui

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
import com.common.ui.UtilitiesView
import com.project.matchlist.uistate.AllMatchUiState
import com.project.matchlist.adapter.MatchFixtureListAdapter
import com.project.presentation.databinding.FragmentMatchListBinding
import com.project.matchlist.viewmodel.AllMatchViewModel
import com.project.room.model.Match
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MatchListFragment : Fragment() {

    private lateinit var binding: FragmentMatchListBinding
    private val allMatchViewModel: AllMatchViewModel by activityViewModels()

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
        retryRequest()
    }

    private fun retryRequest(){
        binding.btnRetry.setOnClickListener {
            requestAllMatches()
        }
    }

    private fun requestAllMatches(){
        allMatchViewModel.fetchMatchListAndInsertInDBVM()
        allMatchViewModel.getAllMatches()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                allMatchViewModel.allMatchUiState.collect {
                    when(it){
                        is AllMatchUiState.Success ->{
                            Log.i("====> ","Matches "+ it.matchList!!.size)
                            if(it.matchList?.size!=0) {
                                updateMatchListAdapter(it.matchList)
                                showOrHideItemInList(false)
                            }else{
                                showOrHideItemInList(true)
                            }
                        }
                        is AllMatchUiState.Failure -> {
                            Log.i("=====> ","Failure: ${it.exception}")
                        }
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

    private fun showOrHideItemInList(needToShow: Boolean){
        UtilitiesView.showOrHideView(binding.noListItemLayout,needToShow)
        UtilitiesView.showOrHideView(binding.fixturesRecyclerview,!needToShow)
        UtilitiesView.showOrHideView(binding.noInternetLayout, !needToShow)
    }

    private fun showOrHideNoInternet(needToShow: Boolean) {
        UtilitiesView.showOrHideView(binding.fixturesRecyclerview,!needToShow)
        UtilitiesView.showOrHideView(binding.noInternetLayout,needToShow)
    }

}