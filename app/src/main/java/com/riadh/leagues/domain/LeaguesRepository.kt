package com.riadh.leagues.domain

import com.riadh.leagues.model.League

interface LeaguesRepository {

    /**
     * get all available leagues from remote DB
     */
    suspend fun getAllLeagues() : List<League>?

    /**
     * get all teams from selected League
     */
    suspend fun getLeagueTeams(leagueName: String)

}