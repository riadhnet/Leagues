package com.riadh.leagues.model

import com.google.gson.annotations.SerializedName


data class Leagues(
    @SerializedName("leagues") var leagues: ArrayList<League> = arrayListOf()
)

data class League(
    @SerializedName("idLeague") var idLeague: String? = null,
    @SerializedName("strLeague") var strLeague: String? = null,
    @SerializedName("strSport") var strSport: String? = null,
    @SerializedName("strLeagueAlternate") var strLeagueAlternate: String? = null

)