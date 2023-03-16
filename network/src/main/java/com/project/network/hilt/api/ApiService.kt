package com.project.network.hilt.api

import com.project.network.hilt.api.NetworkUtil.Companion.API_KEY
import com.project.network.hilt.model.competitions.CompetitionsEntities
import com.project.network.hilt.model.table.NetworkTableEntities
import com.project.network.hilt.model.team.NetworkTeamEntities
import com.project.network.hilt.model.todaymatches.TodayMatchEntities
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("matches")
    @Headers("X-Auth-Token: $API_KEY")
    suspend fun getAllMatches()
            : TodayMatchEntities.NetworkMatchResponse

    @GET("competitions")
    @Headers("X-Auth-Token: $API_KEY")
    suspend fun getAllCompetitions(@Query("plan") plan: String)
            : CompetitionsEntities.NetworkCompetitionsResponse

    @GET("competitions/{id}/standings")
    @Headers("X-Auth-Token: $API_KEY")
    suspend fun getTablesByCompetition(@Path("id") id: Long,
                                       @Query("standingType") standingType: String)
            : NetworkTableEntities.NetworkTableResponse

    @GET("competitions/{id}/teams")
    @Headers("X-Auth-Token: $API_KEY")
    suspend fun getTeamsByCompetition(@Path("id") id: Long)
            : NetworkTeamEntities.NetworkTeamResponse

    @GET("competitions/{id}/matches")
    @Headers("X-Auth-Token: $API_KEY")
    suspend fun getMatchesByCompetition(@Path("id") id: Long,
                                        @Query("dateFrom") dateFrom: String,
                                        @Query("dateTo") dateTo: String)
            : TodayMatchEntities.NetworkMatchResponse
}