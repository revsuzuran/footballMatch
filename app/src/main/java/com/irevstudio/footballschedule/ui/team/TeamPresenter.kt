/*
 * Created On : 10/25/18 10:03 PM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.team

import com.google.gson.Gson
import com.irevstudio.footballschedule.model.TeamResponse
import com.irevstudio.footballschedule.api.ApiRepository
import com.irevstudio.footballschedule.api.FootballDBApi
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class TeamPresenter(private val view: TeamView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun ambilListTim(liga: String?) {
        view.showLoading()
        doAsync {
            val data = gson.fromJson(apiRepository
                    .lakukanPermintaan(FootballDBApi.ambilTeams(liga)),
                    TeamResponse::class.java
            )

            uiThread {
                view.hideLoading()
                view.tampilkanListTim(data.teams)
            }
        }
    }
}