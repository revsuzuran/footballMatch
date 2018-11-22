/*
 * Created On : 10/25/18 10:03 PM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.team

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.irevstudio.footballschedule.R
import com.irevstudio.footballschedule.R.id.*
import com.irevstudio.footballschedule.model.Team
import com.squareup.picasso.Picasso
import org.jetbrains.anko.*

class TeamAdapter(private val teams: List<Team>)
    : RecyclerView.Adapter<TeamViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(TeamUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bindItem(teams[position])
    }
}

class TeamUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL

                imageView {
                    id = R.id.logo_tim
                }.lparams {
                    height = dip(50)
                    width = dip(50)
                }

                textView {
                    id = R.id.nama_tim
                    textSize = 16f
                }.lparams {
                    margin = dip(15)
                }

            }
        }

    }
}

class TeamViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val logoTim: ImageView = view.find(logo_tim)
    private val teamName: TextView = view.find(nama_tim)

    fun bindItem(teams: Team){

        Picasso.get().load(teams.teamBadge).into(logoTim)
        teamName.text = teams.teamName

    }
}