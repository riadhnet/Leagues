package com.riadh.leagues.model

import com.google.gson.annotations.SerializedName


data class Teams(
    @SerializedName("teams") var teams: ArrayList<Team> = arrayListOf()
)

data class Team(
    @SerializedName("strTeamBadge") var strTeamBadge: String? = null,
)