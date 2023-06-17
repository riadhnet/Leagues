package com.riadh.leagues.remote

import com.riadh.leagues.BuildConfig
import com.riadh.leagues.model.Leagues
import retrofit2.Response
import retrofit2.http.GET

interface SportApi {

    @GET(ALL_LEAGUES_PATH)
    suspend fun getLeagues(): Response<Leagues>

    companion object {
        const val ALL_LEAGUES_PATH = "api/v1/json/${BuildConfig.API_KEY}/all_leagues.php"

    }
}
