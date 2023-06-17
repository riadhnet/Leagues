package com.riadh.leagues.remote

import com.riadh.leagues.BuildConfig
import com.riadh.leagues.model.Leagues
import com.riadh.leagues.model.Teams
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SportApi {

    @GET(ALL_LEAGUES_PATH)
    suspend fun getLeagues(): Response<Leagues>

    @GET(TEAMS_PATH)
    suspend fun getTeams(@Query("l") leagueName: String): Response<Teams>

    companion object {
        const val ALL_LEAGUES_PATH = "api/v1/json/${BuildConfig.API_KEY}/all_leagues.php"
        const val TEAMS_PATH = "api/v1/json/${BuildConfig.API_KEY}/search_all_teams.php"

    }
}
