package com.project.network.hilt.api

import com.project.network.hilt.api.NetworkUtil.Companion.API_KEY
import com.project.network.hilt.model.todaymatches.TodayMatchEntities
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @GET("matches")
    @Headers("X-Auth-Token: $API_KEY")
    suspend fun getAllMatches()
            : TodayMatchEntities.NetworkMatchResponse

}