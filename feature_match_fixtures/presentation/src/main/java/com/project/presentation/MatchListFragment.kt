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
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MatchListFragment : Fragment() {

    private val loginViewModel: CompetitionsViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_list, container, false)
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
                            Log.i("=====> ","${it.domainMatchResponse?.matches}")
                        }
                        is CompetitionsUiState.Failure -> {
                            Log.i("=====> ","Failure: ${it.exception}")
                        }
                        else -> {
                            Log.i("=====> ","Else")
                        }
                    }
                }
            }
        }
    }
}