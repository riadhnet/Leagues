package com.riadh.leagues.domain

import com.riadh.leagues.model.League
import com.riadh.leagues.model.Team

interface LeaguesRepository {

    /**
     * get all available leagues from remote DB
     */
    suspend fun getAllLeagues() : List<League>?

    /**
     * get all teams from selected League
     */
    suspend fun getLeagueTeams(leagueName: String): List<Team>?

}