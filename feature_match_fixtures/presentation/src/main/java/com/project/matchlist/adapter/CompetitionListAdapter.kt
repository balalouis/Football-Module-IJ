package com.project.matchlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.presentation.databinding.CompetitionsListRowItemBinding
import com.project.matchlist.utils.Utilities
import com.project.room.model.CompetitionsUiState

class CompetitionListAdapter(private var competitionsUiStateList: List<CompetitionsUiState>) :
    RecyclerView.Adapter<CompetitionListAdapter.CompetitionsListViewHolder>() {

    inner class CompetitionsListViewHolder(val binding: CompetitionsListRowItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompetitionsListViewHolder {
        val binding =
            CompetitionsListRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CompetitionsListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompetitionsListViewHolder, position: Int) {
        val competitions=competitionsUiStateList[position]
        String.format("%1s  %2s/%3s", competitions.name, Utilities.convertSeasonStartDate(competitions.currentSeason.startDate), Utilities.convertSeasonEndDate(competitions.currentSeason.endDate))
        holder.binding.competitionName.text = competitions.name
    }

    override fun getItemCount(): Int = competitionsUiStateList.size

}