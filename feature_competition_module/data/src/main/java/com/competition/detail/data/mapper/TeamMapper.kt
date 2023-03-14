package com.competition.detail.data.mapper

import com.project.network.hilt.model.table.NetworkTableEntities
import com.project.room.model.Table
import com.project.room.model.Team

class TeamMapper {

    companion object {
        fun convertToTeamList(networkStandingList: List<NetworkTableEntities.NetworkStanding>): List<Table>{
            val mainTableList:ArrayList<Table> = ArrayList()
            for(networkStanding in networkStandingList){
                val tempTableList= convertToTableList(networkStanding.table)
                for(table in tempTableList){
                    mainTableList.add(table)
                }
            }
            return mainTableList.toList()
        }

        private fun convertToTableList(networkTableList: List<NetworkTableEntities.NetworkTable>): ArrayList<Table>{
            val tableList:ArrayList<Table> = ArrayList()
            for(networkTable in networkTableList){
                val table=Table(position = networkTable.position,
                    team = convertToTeam(networkTable.team),
                    playedGames = networkTable.playedGames,
                    goalDifference = networkTable.goalDifference,
                    points = networkTable.points
                )
                tableList.add(table)
            }
            return tableList
        }

        private fun convertToTeam(networkTeam: NetworkTableEntities.NetworkTeam) =
            Team (crest = networkTeam.crest, name = networkTeam.name)

    }

}