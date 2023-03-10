package com.project.network.hilt.model.competitions

sealed class CompetitionsEntities{

    data class NetworkCompetitionsResponse(
        val competitions: List<Competition>,
        val count: Int,
        val filters: Filters
    ): CompetitionsEntities()

    data class Competition(
        val area: Area,
        val code: String,
        val currentSeason: CurrentSeason,
        val emblem: String,
        val id: Int,
        val lastUpdated: String,
        val name: String,
        val numberOfAvailableSeasons: Int,
        val plan: String,
        val type: String
    ): CompetitionsEntities()

    data class CurrentSeason(
        val currentMatchday: Int,
        val endDate: String,
        val id: Int,
        val startDate: String,
        val winner: Any
    ): CompetitionsEntities()
    
    data class Filters(
        val client: String
    ): CompetitionsEntities()
}
