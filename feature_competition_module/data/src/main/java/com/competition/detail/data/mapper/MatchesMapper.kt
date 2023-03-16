package com.competition.detail.data.mapper

import com.project.network.hilt.model.competitions.CompetitionsEntities
import com.project.network.hilt.model.todaymatches.TodayMatchEntities
import com.project.room.model.*

class MatchesMapper {

    companion object {

        fun convertToUserList(networkMatchList: List<TodayMatchEntities.NetworkMatch>): List<MatchesByDate> {
            val matchesByDateList: MutableList<MatchesByDate> = mutableListOf()
            for (networkMatch in networkMatchList) {
                val matchesByDate = MatchesByDate(
                    awayTeam = convertToAwayTeam(networkMatch.awayTeam),
                    homeTeam = convertToHomeTeam(networkMatch.homeTeam),
                    matchday = networkMatch.matchday,
                    score = convertToScore(networkMatch.score),
                    status = networkMatch.status,
                    utcDate = networkMatch.utcDate
                )
                matchesByDateList.add(matchesByDate)
            }
            return matchesByDateList.toList()
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

        private fun convertToSession(networkCurrentSeason: CompetitionsEntities.CurrentSeason) =
            CurrentSeason(
                startDate = networkCurrentSeason.startDate,
                endDate = networkCurrentSeason.endDate
            )
    }
}