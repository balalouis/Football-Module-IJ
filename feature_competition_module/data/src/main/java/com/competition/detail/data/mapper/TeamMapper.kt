package com.competition.detail.data.mapper

import com.project.network.hilt.model.team.NetworkTeamEntities
import com.project.room.model.RoomTeam

class TeamMapper {

    companion object{
        fun convertToRoomTeamList(networkTeamList: List<NetworkTeamEntities.NetworkTeam>): List<RoomTeam>{
            val roomTeamList:ArrayList<RoomTeam> = ArrayList()
            for(networkTeam in networkTeamList){
                roomTeamList.add(convertToRoomTeam(networkTeam))
            }
            return roomTeamList
        }

        private fun convertToRoomTeam(networkTeam: NetworkTeamEntities.NetworkTeam) =
            RoomTeam(name = networkTeam.name, crest = networkTeam.crest)
    }

}