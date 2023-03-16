package com.competition.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.competition.detail.databinding.FixtureListRowBinding
import com.competition.detail.utils.Utilities
import com.project.room.model.MatchesByDate

class FixtureListAdapter(private var matchesByDateList: List<MatchesByDate>) :
    RecyclerView.Adapter<FixtureListAdapter.FixtureListViewHolder>() {

    inner class FixtureListViewHolder(val binding: FixtureListRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixtureListViewHolder {
        val binding =
            FixtureListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FixtureListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FixtureListViewHolder, position: Int) {
        val match=matchesByDateList[position];
        holder.binding.matchStatus.text = match.status
        holder.binding.textView2.text = Utilities.convertDate(match.utcDate)
        holder.binding.textView3.text = String.format("MD: %d",match.matchday)
        holder.binding.firstPlayer.text = match.homeTeam?.name
        holder.binding.secondPlayer.text = match.awayTeam.name
        holder.binding.firstPlayerScore.text = match.score?.fullTime?.home.toString()
        holder.binding.secondPlayerScore.text = match.score?.fullTime?.away.toString()
        holder.binding.matchTime.text = Utilities.showMatchTime(match.status, match.utcDate, match.score)
    }

    override fun getItemCount(): Int = matchesByDateList.size

}