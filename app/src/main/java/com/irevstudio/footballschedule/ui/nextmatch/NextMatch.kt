/*
 * Created On : 10/25/18 10:03 PM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.nextmatch

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ProgressBar
import com.google.gson.Gson
import com.irevstudio.footballschedule.R
import com.irevstudio.footballschedule.api.ApiRepository
import com.irevstudio.footballschedule.model.Event
import com.irevstudio.footballschedule.util.Visible
import com.irevstudio.footballschedule.util.inVisible
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.UI
import org.jetbrains.anko.support.v4.onRefresh
import org.jetbrains.anko.support.v4.swipeRefreshLayout


class NextMatch : Fragment(), NextMatchView {

        private var events: MutableList<Event> = mutableListOf()
        private lateinit var presenter: NextMatchPresenter
        private lateinit var adapter: NextMatchAdapter
        private lateinit var listEvent: RecyclerView
        private lateinit var progressBar: ProgressBar
        private lateinit var swipeRefresh: SwipeRefreshLayout
        private val eventType: String = "next"
        private val leagueId: String = "4328"

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            // Inflate the layout for this fragment
            val ui = UI {
                linearLayout {
                    lparams(width = matchParent, height = wrapContent)
                    orientation = LinearLayout.VERTICAL
                    topPadding = dip(16)
                    leftPadding = dip(16)
                    rightPadding = dip(16)

                    swipeRefresh = swipeRefreshLayout {
                        setColorSchemeResources(R.color.colorAccent,
                                android.R.color.holo_green_light,
                                android.R.color.holo_orange_light,
                                android.R.color.holo_red_light)

                        relativeLayout {
                            lparams(width = matchParent, height = wrapContent)

                            listEvent = recyclerView {
                                lparams(width = matchParent, height = wrapContent)
                                layoutManager = LinearLayoutManager(ctx)
                            }

                            progressBar = progressBar {
                            }.lparams {
                                centerHorizontally()
                            }
                        }
                    }
                }

            }

            adapter = NextMatchAdapter(events)
            listEvent.adapter = adapter

            val req = ApiRepository()
            val gson = Gson()
            presenter = NextMatchPresenter(this, req, gson)
            presenter.ambilListEvent(leagueId, eventType)

            swipeRefresh.onRefresh { presenter.ambilListEvent(leagueId, eventType) }

            return ui.view
        }

        override fun hideLoading() {
            progressBar.inVisible()
        }

        override fun showLoading() {
            progressBar.Visible()
        }

        override fun tampilkanNextEvent(data: List<Event>) {
            swipeRefresh.isRefreshing = false
            events.clear()
            events.addAll(data)
            adapter.notifyDataSetChanged()
        }

    }
