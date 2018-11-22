/*
 * Created On : 10/25/18 10:03 PM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.api

import android.net.Uri
import com.irevstudio.footballschedule.BuildConfig

object FootballDBApi{

    fun ambilTeams(liga: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("search_all_teams.php")
                .appendQueryParameter("l", liga)
                .build()
                .toString()
    }

    fun ambilEvent (id: String?, eventType: String?): String {

        var url: String? = null

        if(eventType == "prev") {
            url = "eventspastleague.php"
        } else if(eventType == "next"){
            url = "eventsnextleague.php"
        }

        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath(url)
                .appendQueryParameter("id", id)
                .build()
                .toString()
    }

    fun ambilDetailEvent(id: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("lookupevent.php")
                .appendQueryParameter("id", id)
                .build()
                .toString()
    }

    fun ambilDetailteam(id: String?): String {
        return Uri.parse(BuildConfig.BASE_URL).buildUpon()
                .appendPath("api")
                .appendPath("v1")
                .appendPath("json")
                .appendPath(BuildConfig.TSDB_API_KEY)
                .appendPath("lookupteam.php")
                .appendQueryParameter("id", id)
                .build()
                .toString()
    }
}