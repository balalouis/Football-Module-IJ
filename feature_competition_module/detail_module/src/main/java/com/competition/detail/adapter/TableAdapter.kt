package com.competition.detail.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.competition.detail.databinding.TableListRowBinding
import com.project.room.model.Table

class TableListAdapter(private var tableList: List<Table>) :
    RecyclerView.Adapter<TableListAdapter.TableListViewHolder>() {

    inner class TableListViewHolder(val binding: TableListRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TableListViewHolder {
        val binding =
            TableListRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TableListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TableListViewHolder, position: Int) {
        val table=tableList[position]
        Log.i("-----> onBindViewHolder","${table.team.name}")
        holder.binding.id.text = table.position.toString()
        holder.binding.clubName.text = table.team.name
        holder.binding.score1.text = table.playedGames.toString()
        holder.binding.score2.text = table.goalDifference.toString()
        holder.binding.score3.text = table.points.toString()
    }

    override fun getItemCount(): Int {
        return tableList.size
    }

}