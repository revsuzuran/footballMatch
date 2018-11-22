/*
 * Created On : 10/25/18 10:16 PM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.lastmatch

import com.google.gson.Gson
import com.irevstudio.footballschedule.api.ApiRepository
import com.irevstudio.footballschedule.api.FootballDBApi
import com.irevstudio.footballschedule.model.EventResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class LastMatchPresenter(private val view: LastMatchView,
                    private val apiRepository: ApiRepository,
                    private val gson: Gson) {

    fun ambilListEvent(leagueId: String?, eventType: String?) {
        view.showLoading()
        doAsync {
            val datas = gson.fromJson(apiRepository
                    .lakukanPermintaan(FootballDBApi.ambilEvent(leagueId,eventType)),
                    EventResponse::class.java
            )

//            Log.d("aqil", FootballDBApi.ambilEvent(leagueId,eventType))
//            Log.e("the data", "$datas")

            uiThread {
                view.hideLoading()
                view.tampilkanLastEvent(datas.events)
                //

            }
        }
    }
}