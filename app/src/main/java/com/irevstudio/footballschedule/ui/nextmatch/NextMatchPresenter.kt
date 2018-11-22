/*
 * Created On : 10/29/18 5:27 AM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.nextmatch

import android.util.Log
import com.google.gson.Gson
import com.irevstudio.footballschedule.api.ApiRepository
import com.irevstudio.footballschedule.api.FootballDBApi
import com.irevstudio.footballschedule.model.EventResponse
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread

class NextMatchPresenter(private val view: NextMatchView,
                         private val apiRepository: ApiRepository,
                         private val gson: Gson) {

    fun ambilListEvent(leagueId: String?, eventType: String?) {
        view.showLoading()
        doAsync {
            val datas = gson.fromJson(apiRepository
                    .lakukanPermintaan(FootballDBApi.ambilEvent(leagueId,eventType)),
                    EventResponse::class.java
            )
//
//            Log.d("aqil", FootballDBApi.ambilEvent(leagueId,eventType))
//            Log.e("the data", "$datas")

            uiThread {
                view.hideLoading()
                view.tampilkanNextEvent(datas.events)
                //

            }
        }
    }
}