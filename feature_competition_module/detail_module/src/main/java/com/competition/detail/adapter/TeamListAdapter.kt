package com.competition.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.competition.detail.databinding.TeamListRowBinding
import com.project.room.model.RoomTeam

class TeamListAdapter(private var roomTeamList: List<RoomTeam>) :
    RecyclerView.Adapter<TeamListAdapter.TeamListViewHolder>() {

    inner class TeamListViewHolder(val binding: TeamListRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamListViewHolder {
        val binding =
            TeamListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TeamListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TeamListViewHolder, position: Int) {
        val roomTeam=roomTeamList[position]
    }

    override fun getItemCount(): Int {
        return roomTeamList.size
    }

}