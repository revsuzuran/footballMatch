/*
 * Created On : 10/29/18 5:24 AM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.nextmatch

import com.irevstudio.footballschedule.model.Event

interface NextMatchView{
    fun showLoading()
    fun hideLoading()
    fun tampilkanNextEvent(data: List<Event>)
}