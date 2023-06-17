package com.riadh.leagues.domain

import android.util.Log
import com.riadh.leagues.model.League
import com.riadh.leagues.model.Team
import com.riadh.leagues.remote.SportApi
import javax.inject.Inject

class LeaguesRepositoryImp @Inject constructor(private val api: SportApi) : LeaguesRepository {

    override suspend fun getAllLeagues(): List<League>? {
        api.getLeagues().let { response ->
            if (response.isSuccessful) {
                return response.body()?.leagues
            } else {
                manageServerError(response.code())
                return emptyList()
            }
        }
    }

    override suspend fun getLeagueTeams(leagueName: String): List<Team>? {
        api.getTeams(leagueName).let { response ->
            if (response.isSuccessful) {
                return response.body()?.teams
            } else {
                manageServerError(response.code())
                return emptyList()
            }
        }
    }

    private fun manageServerError(code: Int) {
        //todo manage loading and server error
        Log.e("API", "error $code")
    }

}