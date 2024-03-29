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
import com.competition.detail.adapter.TableListAdapter
import com.competition.detail.databinding.FragmentTableBinding
import com.competition.detail.uistate.AllTableUiState
import com.competition.detail.viewmodel.TableViewModel
import com.project.room.model.Table
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TableFragment : Fragment() {

    private lateinit var binding: FragmentTableBinding
    private val tableViewModel: TableViewModel by activityViewModels()
    var competitionId: Long = 0L

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTableBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getIntents()
        requestTable()
    }

    private fun getIntents() {
        competitionId = arguments?.getLong("id")!!
    }

    private fun requestTable(){
        tableViewModel.fetchMatchListAndInsertInDBVM(competitionId)
        tableViewModel.getAllTables()

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                tableViewModel.allTableUiState.collect {
                    when(it){
                        is AllTableUiState.Success ->{
                            if(it.tableList?.size!! > 0) {
                                updateTableListAdapter(it.tableList)
                            }
                        }
                        is AllTableUiState.Failure -> {
                            Log.i("=====> ","Failure: ${it.exception}")
                        }
                    }
                }
            }
        }
    }

   private fun updateTableListAdapter(tableList: List<Table>?) {
        val tableListAdapter = tableList?.let { context?.let { _ -> TableListAdapter(it) } }
        val tableListRecyclerView = binding.tableRecyclerview
        tableListRecyclerView.adapter = tableListAdapter
        tableListRecyclerView.layoutManager = LinearLayoutManager(activity)
    }

}