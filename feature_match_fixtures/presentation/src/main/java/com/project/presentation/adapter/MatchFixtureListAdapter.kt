package com.project.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.project.presentation.databinding.MatchListRowItemBinding
import com.project.presentation.utils.Utilities
import com.project.room.model.Match

class MatchFixtureListAdapter(private var matchList: List<Match>) :
    RecyclerView.Adapter<MatchFixtureListAdapter.MatchListViewHolder>() {

    inner class MatchListViewHolder(val binding: MatchListRowItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchListViewHolder {
        val binding =
            MatchListRowItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MatchListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MatchListViewHolder, position: Int) {
        val match=matchList[position];
        holder.binding.matchStatus.text = match.status
        holder.binding.textView2.text = Utilities.convertDate(match.utcDate)
        holder.binding.textView3.text = String.format("MD: %d",match.matchday)
        holder.binding.firstPlayer.text = match.homeTeam?.name
        holder.binding.secondPlayer.text = match.awayTeam.name
        holder.binding.firstPlayerScore.text = match.score?.fullTime?.home.toString()
        holder.binding.secondPlayerScore.text = match.score?.fullTime?.away.toString()
        holder.binding.matchTime.text = Utilities.showMatchTime(match.status, match.utcDate, match.score)
    }

    override fun getItemCount(): Int = matchList.size

}