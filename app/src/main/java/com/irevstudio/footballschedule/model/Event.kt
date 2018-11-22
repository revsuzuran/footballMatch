/*
 * Created On : 10/25/18 10:03 PM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.model

import com.google.gson.annotations.SerializedName

class Event(

        //=============== globalData
        @SerializedName("idEvent")
        var idEvent: String? = null,

        //=============== AWAY TEAM DATA
        @SerializedName("idAwayTeam")
        var idTeamAway: String,

        @SerializedName("strAwayTeam")
        var teamAway: String,

        //AWAY MATCH STATS
        @SerializedName("intAwayScore")
        var teamAwayScore: Int,

        @SerializedName("intAwayShots")
        var intAwayShots: String? = null,

        @SerializedName("strAwayGoalDetails")
        var teamAwayGoal: String,


        //AWAY LINEUPS
        @SerializedName("strAwayLineupSubstitutes")
        var strAwayLineupSubstitutes: String? = null,

        @SerializedName("strAwayLineupGoalkeeper")
        var strAwayLineupGoalkeeper: String? = null,

        @SerializedName("strAwayLineupMidfield")
        var strAwayLineupMid: String? = null,

        @SerializedName("strAwayLineupForward")
        var strAwayLineupForward: String? = null,

        @SerializedName("strAwayLineupDefense")
        var strAwayLineupDefense: String? = null,



        //============ HOME TEAM DATA
        @SerializedName("idHomeTeam")
        var idTeamHome: String,

        @SerializedName("strHomeTeam")
        var teamHome: String,

        @SerializedName("strHomeGoalDetails")
        var teamHomeGoal: String,

        //HOME MATCH STATS
        @SerializedName("intHomeScore")
        var teamHomeScore: Int,

        @SerializedName("intHomeShots")
        var intHomeShots: String? = null,

        //HOME LINEUPS
        @SerializedName("strHomeLineupDefense")
        var strHomeLineupDefense: String? = null,

        @SerializedName("strHomeLineupForward")
        var strHomeLineupForward: String? = null,

        @SerializedName("strHomeLineupMidfield")
        var strHomeLineupMid: String? = null,

        @SerializedName("strHomeLineupGoalkeeper")
        var strHomeLineupGoalkeeper: String? = null,

        @SerializedName("strHomeLineupSubstitutes")
        var strHomeLineupSubstitutes: String? = null
)