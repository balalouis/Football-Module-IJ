package com.competition.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.competition.detail.R
import com.competition.detail.databinding.TeamListRowBinding
import com.project.room.model.RoomTeam
import com.squareup.picasso.Picasso

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
        holder.binding.clubName.text = roomTeam.name
        setImageResource(holder,roomTeam)
    }

    private fun setImageResource(holder: TeamListViewHolder, roomTeam: RoomTeam){
        Picasso.get()
            .load(roomTeam.crest).fit().centerCrop()
            .placeholder(R.drawable.ic_baseline_account_circle_24)
            .error(R.drawable.ic_baseline_account_circle_24)
            .into(holder.binding.clubLogo)
    }

    override fun getItemCount(): Int {
        return roomTeamList.size
    }

}