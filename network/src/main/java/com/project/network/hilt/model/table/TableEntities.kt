package com.project.network.hilt.model.table

sealed class TableEntities{

    data class NetworkTableResponse(
        val area: Area,
        val competition: Competition,
        val filters: Filters,
        val season: Season,
        val standings: List<Standing>): TableEntities()

    data class Area(
        val code: String,
        val flag: String,
        val id: Int,
        val name: String
    ): TableEntities()

    data class Competition(
        val code: String,
        val emblem: String,
        val id: Int,
        val name: String,
        val type: String
    ):TableEntities()

    data class Filters(
        val season: String
    ):TableEntities()

    data class Season(
        val currentMatchday: Int,
        val endDate: String,
        val id: Int,
        val startDate: String,
        val winner: Any
    ):TableEntities()


    data class Standing(
        val group: Any,
        val stage: String,
        val table: List<Table>,
        val type: String
    ):TableEntities()

    data class Table(
        val draw: Int,
        val form: String,
        val goalDifference: Int,
        val goalsAgainst: Int,
        val goalsFor: Int,
        val lost: Int,
        val playedGames: Int,
        val points: Int,
        val position: Int,
        val team: Team,
        val won: Int
    ):TableEntities()

    data class Team(
        val crest: String,
        val id: Int,
        val name: String,
        val shortName: String,
        val tla: String
    ):TableEntities()
}
