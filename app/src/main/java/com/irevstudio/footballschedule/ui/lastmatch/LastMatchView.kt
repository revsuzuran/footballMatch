/*
 * Created On : 10/25/18 10:16 PM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.lastmatch

import com.irevstudio.footballschedule.model.Event

interface LastMatchView{
    fun hideLoading()
    fun showLoading()
    fun tampilkanLastEvent(dataEvent: List<Event>)

}