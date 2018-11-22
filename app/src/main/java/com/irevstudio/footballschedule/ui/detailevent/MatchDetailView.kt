/*
 * Created On : 10/29/18 9:03 AM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.detailevent

import com.irevstudio.footballschedule.model.Event
import com.irevstudio.footballschedule.model.Team

interface MatchDetailView{
    fun tampilkanMatchDetail(dataEvent: Event?,dataHome: Team?,dataAway: Team?)
}