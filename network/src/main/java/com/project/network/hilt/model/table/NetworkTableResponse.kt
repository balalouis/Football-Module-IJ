package com.project.network.hilt.model.table


sealed class NetworkTableEntities{

    data class NetworkTableResponse(
        val standings: List<NetworkStanding>): NetworkTableEntities()

    data class NetworkArea(
        val code: String,
        val flag: String,
        val id: Int,
        val name: String
    ): NetworkTableEntities()

    data class NetworkCompetition(
        val code: String,
        val emblem: String,
        val id: Int,
        val name: String,
        val type: String
    ):NetworkTableEntities()

    data class NetworkFilters(
        val season: String
    ):NetworkTableEntities()

    data class NetworkSeason(
        val currentMatchday: Int,
        val endDate: String,
        val id: Int,
        val startDate: String,
        val winner: Any
    ):NetworkTableEntities()


    data class NetworkStanding(
        val group: Any,
        val stage: String,
        val table: List<NetworkTable>,
        val type: String
    ):NetworkTableEntities()

    data class NetworkTable(
        val draw: Int,
        val form: String,
        val goalDifference: Int,
        val goalsAgainst: Int,
        val goalsFor: Int,
        val lost: Int,
        val playedGames: Int,
        val points: Int,
        val position: Int,
        val team: NetworkTeam,
        val won: Int
    ):NetworkTableEntities()

    data class NetworkTeam(
        val crest: String,
        val id: Int,
        val name: String,
        val shortName: String,
        val tla: String
    ):NetworkTableEntities()
}