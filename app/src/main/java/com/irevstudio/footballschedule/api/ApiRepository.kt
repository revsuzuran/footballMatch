/*
 * Created On : 10/25/18 10:03 PM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.api

import java.net.URL

class ApiRepository{

    fun lakukanPermintaan(url: String): String{
        return URL(url).readText()
    }
}