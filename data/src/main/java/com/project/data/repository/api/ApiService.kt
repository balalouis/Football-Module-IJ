package com.project.data.repository.api

import com.project.data.repository.api.NetworkUtil.Companion.API_KEY
import com.project.domain.model.TodayMatchEntities
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {

    @GET("matches")
    @Headers("X-Auth-Token: $API_KEY")
    suspend fun getAllMatches(@Query("dateFrom") dateFrom: String,
                              @Query("dateTo") dateTo: String)
            : TodayMatchEntities.DomainMatchResponse

}