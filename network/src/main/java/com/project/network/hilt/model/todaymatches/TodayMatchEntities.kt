package com.project.network.hilt.model.todaymatches

import java.util.ArrayList

sealed class TodayMatchEntities {

    /**
     *  Data classes for Matches
    */

    data class NetworkMatchResponse(
        var matches: List<NetworkMatch> = ArrayList()
    ): TodayMatchEntities()

    data class NetworkMatch(
        val area: NetworkArea,
        val awayTeam: NetworkAwayTeam,
        val competition: NetworkCompetition,
        val group: Any,
        val homeTeam: NetworkHomeTeam,
        val id: Int,
        val lastUpdated: String,
        val matchday: Int,
        val odds: NetworkOdds,
        val referees: List<Any>,
        val score: NetworkScore,
        val season: NetworkSeason,
        val stage: String,
        val status: String,
        val utcDate: String
    ): TodayMatchEntities()

    data class NetworkArea(
        val code: String,
        val flag: String,
        val id: Int,
        val name: String
    ): TodayMatchEntities()

    data class NetworkAwayTeam(
        val crest: String,
        val id: Int,
        val name: String,
        val shortName: String,
        val tla: String
    ): TodayMatchEntities()

    data class NetworkCompetition(
        val code: String,
        val emblem: String,
        val id: Int,
        val name: String,
        val type: String
    ): TodayMatchEntities()

    data class NetworkHomeTeam(
        val crest: String,
        val id: Int,
        val name: String,
        val shortName: String,
        val tla: String
    ): TodayMatchEntities()

    data class NetworkOdds(
        val msg: String
    ): TodayMatchEntities()

    data class NetworkScore(
        val duration: String,
        val fullTime: NetworkFullTime,
        val halfTime: NetworkHalfTime,
        val winner: String
    ): TodayMatchEntities()

    data class NetworkFullTime(
        val away: Int,
        val home: Int
    ): TodayMatchEntities()

    data class NetworkHalfTime(
        val away: Int,
        val home: Int
    ): TodayMatchEntities()

    data class NetworkSeason(
        val currentMatchday: Int,
        val endDate: String,
        val id: Int,
        val startDate: String,
        val winner: Any
    ): TodayMatchEntities()
}