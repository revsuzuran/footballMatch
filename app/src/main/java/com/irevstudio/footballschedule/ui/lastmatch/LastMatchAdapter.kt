/*
 * Created On : 10/25/18 10:17 PM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.lastmatch

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.irevstudio.footballschedule.R
import com.irevstudio.footballschedule.model.Event
import org.jetbrains.anko.*

class LastMatchAdapter(private val event: List<Event>, private val listener: (Event) -> Unit)
    :RecyclerView.Adapter<LastMatchViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LastMatchViewHolder {
        return LastMatchViewHolder(LastMatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = event.size

    override fun onBindViewHolder(holder: LastMatchViewHolder, position: Int) {
        holder.bindItem(event[position], listener)
    }

}

class LastMatchUI : AnkoComponent<ViewGroup> {
    override fun createView(ui: AnkoContext<ViewGroup>): View {
        return with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent){
                    bottomMargin = dip(10)
                    backgroundResource = R.color.colorPrimary
                }
                padding = dip(16)
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER

//                imageView {
//                    id = R.id.lastMatch_homeLogo
//                }.lparams {
//                    height = dip(30)
//                    width = dip(30)
//                }

                textView {
                    id = R.id.lastMatch_homeName
                    textSize = 16f
                    textAlignment = LinearLayout.TEXT_ALIGNMENT_CENTER
                    textColor = Color.WHITE
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    weight = 0.5f
                }

                textView {
                    id = R.id.lastMatch_homeSkor
                    textSize = 16f
                    textColor = Color.WHITE
                }

                textView {
                    text = ctx.getString(R.string.versus)
                    textSize = 20f
                    textColor = Color.WHITE
                }.lparams{margin = dip(10)}

                textView {
                    id = R.id.lastMatch_awaySkor
                    textSize = 16f
                    textColor = Color.WHITE
                }

                textView {
                    id = R.id.lastMatch_awayName
                    textSize = 16f
                    textAlignment = LinearLayout.TEXT_ALIGNMENT_CENTER
                    textColor = Color.WHITE
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    weight = 0.5f
                }

//                imageView {
//                    id = R.id.lastMatch_awayLogo
//                }.lparams {
//                    height = dip(30)
//                    width = dip(30)
//                }



            }
        }

    }
}

class LastMatchViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val homeName: TextView = view.find(R.id.lastMatch_homeName)
    private val homeSkor: TextView = view.find(R.id.lastMatch_homeSkor)
    private val awayName: TextView = view.find(R.id.lastMatch_awayName)
    private val awaySkor: TextView = view.find(R.id.lastMatch_awaySkor)

    fun bindItem(event: Event, listener: (Event) -> Unit){

        homeName.text = event.teamHome
        homeSkor.text = event.teamHomeScore.toString();if(homeSkor.text == null){homeSkor.text = "-"}
        awayName.text = event.teamAway
        awaySkor.text = event.teamAwayScore.toString();if(awaySkor.text == null){homeSkor.text = "-"}

        itemView.setOnClickListener {
            listener(event)
        }

    }
}