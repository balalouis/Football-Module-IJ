package com.project.network.hilt.model

import java.util.ArrayList

sealed class TodayMatchEntities {

    /**
     *  Data classes for Matches
    */

    data class DomainMatchResponse(
        var matches: List<Matche> = ArrayList()
    ): TodayMatchEntities()

    data class Matche(
        val area: Area,
        val awayTeam: AwayTeam,
        val competition: Competition,
        val group: Any,
        val homeTeam: HomeTeam,
        val id: Int,
        val lastUpdated: String,
        val matchday: Int,
        val odds: Odds,
        val referees: List<Any>,
        val score: Score,
        val season: Season,
        val stage: String,
        val status: String,
        val utcDate: String
    ): TodayMatchEntities()

    data class Area(
        val code: String,
        val flag: String,
        val id: Int,
        val name: String
    ): TodayMatchEntities()

    data class AwayTeam(
        val crest: String,
        val id: Int,
        val name: String,
        val shortName: String,
        val tla: String
    ): TodayMatchEntities()

    data class Competition(
        val code: String,
        val emblem: String,
        val id: Int,
        val name: String,
        val type: String
    ): TodayMatchEntities()

    data class HomeTeam(
        val crest: String,
        val id: Int,
        val name: String,
        val shortName: String,
        val tla: String
    ): TodayMatchEntities()

    data class Odds(
        val msg: String
    ): TodayMatchEntities()

    data class Score(
        val duration: String,
        val fullTime: FullTime,
        val halfTime: HalfTime,
        val winner: String
    ): TodayMatchEntities()

    data class FullTime(
        val away: Int,
        val home: Int
    ): TodayMatchEntities()

    data class HalfTime(
        val away: Int,
        val home: Int
    ): TodayMatchEntities()

    data class Season(
        val currentMatchday: Int,
        val endDate: String,
        val id: Int,
        val startDate: String,
        val winner: Any
    ): TodayMatchEntities()
}