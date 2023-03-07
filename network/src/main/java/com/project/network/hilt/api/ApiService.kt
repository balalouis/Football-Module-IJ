package com.project.network.hilt.api

import com.project.network.hilt.model.TodayMatchEntities
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query
import com.project.mydata.api.NetworkUtil.Companion.API_KEY as API_KEY1

interface ApiService {

    @GET("matches")
    @Headers("X-Auth-Token: $API_KEY1")
    suspend fun getAllMatches(@Query("dateFrom") dateFrom: String,
                              @Query("dateTo") dateTo: String)
            : TodayMatchEntities.DomainMatchResponse

}