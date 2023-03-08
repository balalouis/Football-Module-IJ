package com.project.data.mapper

import com.project.network.hilt.model.TodayMatchEntities
import com.project.room.model.*

class MatchListMapper {

    companion object {

        fun convertToUserList(networkMatchList: List<TodayMatchEntities.NetworkMatch>): List<Match> {
            val matchList: MutableList<Match> = mutableListOf()
            for (networkMatch in networkMatchList) {
                val match = Match(
                    awayTeam = convertToAwayTeam(networkMatch.awayTeam),
                    homeTeam = convertToHomeTeam(networkMatch.homeTeam),
                    matchday = networkMatch.matchday,
                    score = convertToScore(networkMatch.score),
                    status = networkMatch.status,
                    utcDate = networkMatch.utcDate
                )
                matchList.add(match)
            }
            return matchList.toList()
        }

        private fun convertToAwayTeam(networkAwayTeam: TodayMatchEntities.NetworkAwayTeam?) =
            AwayTeam(networkAwayTeam?.name)

        private fun convertToHomeTeam(networkHomeTeam: TodayMatchEntities.NetworkHomeTeam?) =
            HomeTeam(networkHomeTeam?.name)

        private fun convertToFullTime(networkFullTime: TodayMatchEntities.NetworkFullTime?) =
            FullTime(networkFullTime?.away, networkFullTime?.home)

        private fun convertToHalTime(networkHalfTime: TodayMatchEntities.NetworkHalfTime?) =
            HalfTime(networkHalfTime?.away, networkHalfTime?.home)

        private fun convertToScore(networkScore: TodayMatchEntities.NetworkScore?) =
            Score(
                convertToFullTime(networkScore?.fullTime),
                convertToHalTime(networkScore?.halfTime)
            )
    }
}