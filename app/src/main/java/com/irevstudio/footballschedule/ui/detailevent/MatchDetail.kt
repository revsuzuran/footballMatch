/*
 * Created On : 10/29/18 9:02 AM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.detailevent

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.google.gson.Gson
import com.irevstudio.footballschedule.R
import com.irevstudio.footballschedule.api.ApiRepository
import com.irevstudio.footballschedule.model.Event
import com.irevstudio.footballschedule.model.Team
import com.irevstudio.footballschedule.util.Visible
import com.irevstudio.footballschedule.util.inVisible
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_match_detail.*
import org.jetbrains.anko.support.v4.onRefresh

class MatchDetail : AppCompatActivity(), MatchDetailView {

    private lateinit var presenter: MatchDetailPresenter
    private lateinit var eventID: String
    private lateinit var homeID: String
    private lateinit var awayID: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_match_detail)

        eventID = intent.getStringExtra("idEvent")
        homeID = intent.getStringExtra("idHomeTeam")
        awayID = intent.getStringExtra("idAwayTeam")

        val req = ApiRepository()
        val gson = Gson()
        presenter = MatchDetailPresenter(this, req, gson)
        presenter.ambilListEvent(eventID,homeID,awayID)

        swipe.onRefresh {
            presenter = MatchDetailPresenter(this, req, gson)
            presenter.ambilListEvent(eventID,homeID,awayID)

        }

    }


    override fun tampilkanMatchDetail(dataEvent: Event?,dataHome: Team?,dataAway: Team?) {
        swipe.isRefreshing = false
        ed_namaHome.text = dataEvent?.teamHome
        ed_skorHome.text = dataEvent?.teamHomeScore.toString()
        ed_goalHome.text = dataEvent?.teamHomeGoal.toString().replace(";","\n")
        ed_keeperHome.text = dataEvent?.strHomeLineupGoalkeeper.toString().replace(";","\n")
        ed_defenseHome.text = dataEvent?.strHomeLineupDefense.toString().replace(";","\n")
        ed_midHome.text = dataEvent?.strHomeLineupMid.toString().replace(";","\n")
        ed_forwardHome.text = dataEvent?.strHomeLineupForward.toString().replace(";","\n")
        ed_subsHome.text = dataEvent?.strHomeLineupSubstitutes.toString().replace(";","\n")

        ed_namaAway.text = dataEvent?.teamAway
        ed_skorAway.text = dataEvent?.teamAwayScore.toString()
        ed_goalAway.text = dataEvent?.teamAwayGoal.toString().replace(";","\n")
        ed_keeperAway.text = dataEvent?.strAwayLineupGoalkeeper.toString().replace(";","\n")
        ed_defenseAway.text = dataEvent?.strAwayLineupDefense.toString().replace(";","\n")
        ed_midAway.text = dataEvent?.strAwayLineupMid.toString().replace(";","\n")
        ed_forwardAway.text = dataEvent?.strAwayLineupForward.toString().replace(";","\n")
        ed_subsAway.text = dataEvent?.strAwayLineupSubstitutes.toString().replace(";","\n")

        Picasso.get().load(dataHome?.teamBadge).into(ed_imageHome)
        Picasso.get().load(dataAway?.teamBadge).into(ed_imageAway)

    }

}
