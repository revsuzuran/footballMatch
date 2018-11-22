/*
 * Created On : 10/29/18 9:02 AM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.detailevent

import android.util.Log
import com.google.gson.Gson
import com.irevstudio.footballschedule.api.ApiRepository
import com.irevstudio.footballschedule.api.FootballDBApi
import com.irevstudio.footballschedule.model.EventResponse
import com.irevstudio.footballschedule.model.TeamResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class MatchDetailPresenter(private val view: MatchDetailView,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson) {

    fun ambilListEvent(idEvent: String?, idHome: String?, idAway: String?) {
        doAsync {
            val dataEvent = gson.fromJson(apiRepository
                    .lakukanPermintaan(FootballDBApi.ambilDetailEvent(idEvent)),
                    EventResponse::class.java
            )
            val dataTeamHome = gson.fromJson(apiRepository
                    .lakukanPermintaan(FootballDBApi.ambilDetailteam(idHome)),
                    TeamResponse::class.java
            )
            val dataTeamAway = gson.fromJson(apiRepository
                    .lakukanPermintaan(FootballDBApi.ambilDetailteam(idAway)),
                    TeamResponse::class.java
            )

            Log.d("aqil", FootballDBApi.ambilDetailteam(idAway))
                   Log.e("the data", "$dataTeamHome")

            uiThread {
                view.tampilkanMatchDetail(dataEvent.events[0], dataTeamHome.teams[0], dataTeamAway.teams[0])
                //

            }
        }
    }
}