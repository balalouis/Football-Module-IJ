package com.project.network.hilt.model.team

sealed class NetworkTeamEntities {

    data class NetworkTeamResponse(
        val competition: NetworkCompetition,
        val count: Int,
        val filters: NetworkFilters,
        val season: NetworkSeason,
        val teams: List<NetworkTeam>
    ):NetworkTeamEntities()

    data class NetworkArea(
        val code: String,
        val flag: String,
        val id: Int,
        val name: String
    ):NetworkTeamEntities()

    data class NetworkCoach(
        val contract: NetworkContract,
        val dateOfBirth: String,
        val firstName: String,
        val id: Int,
        val lastName: String,
        val name: String,
        val nationality: String
    ):NetworkTeamEntities()


    data class NetworkCompetition(
        val code: String,
        val emblem: String,
        val id: Int,
        val name: String,
        val type: String
    ):NetworkTeamEntities()


    data class NetworkContract(
        val start: Any,
        val until: Any
    ):NetworkTeamEntities()


    data class NetworkFilters(
        val season: String
    ):NetworkTeamEntities()


    data class NetworkRunningCompetition(
        val code: String,
        val emblem: String,
        val id: Int,
        val name: String,
        val type: String
    ):NetworkTeamEntities()


    data class NetworkSeason(
        val currentMatchday: Int,
        val endDate: String,
        val id: Int,
        val startDate: String,
        val winner: Any
    ):NetworkTeamEntities()


    data class NetworkSquad(
        val dateOfBirth: String,
        val id: Int,
        val name: String,
        val nationality: String,
        val position: String
    ):NetworkTeamEntities()

    data class NetworkStaff(
        val contract: NetworkContract,
        val dateOfBirth: String,
        val firstName: String,
        val id: Int,
        val lastName: Any,
        val name: String,
        val nationality: String
    ):NetworkTeamEntities()


    data class NetworkTeam(
        val address: String,
        val area: NetworkArea,
        val clubColors: String,
        val coach: NetworkCoach,
        val crest: String,
        val founded: Int,
        val id: Int,
        val lastUpdated: String,
        val name: String,
        val runningCompetitions: List<NetworkRunningCompetition>,
        val shortName: String,
        val squad: List<NetworkSquad>,
        val staff: List<NetworkStaff>,
        val tla: String,
        val venue: String,
        val website: String
    ):NetworkTeamEntities()
}