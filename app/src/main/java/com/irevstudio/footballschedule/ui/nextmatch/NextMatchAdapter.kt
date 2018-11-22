/*
 * Created On : 10/29/18 5:27 AM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.ui.nextmatch

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.irevstudio.footballschedule.R
import com.irevstudio.footballschedule.model.Event
import org.jetbrains.anko.*

class NextMatchAdapter(private val event: List<Event>)
    : RecyclerView.Adapter<NextMatchViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NextMatchViewHolder {
        return NextMatchViewHolder(NextMatchUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = event.size

    override fun onBindViewHolder(holder: NextMatchViewHolder, position: Int) {
        holder.bindItem(event[position])
    }

}

class NextMatchUI : AnkoComponent<ViewGroup> {
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

                textView {
                    id = R.id.nextMatch_homeName
                    textSize = 16f
                    textAlignment = LinearLayout.TEXT_ALIGNMENT_CENTER
                    textColor = Color.WHITE
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    weight = 0.5f
                }

                textView {
                    id = R.id.nextMatch_homeSkor
                    textSize = 16f
                    textColor = Color.WHITE
                }

                textView {
                    text = ctx.getString(R.string.versus)
                    textSize = 20f
                    textColor = Color.WHITE
                }.lparams{margin = dip(10)}

                textView {
                    id = R.id.nextMatch_awaySkor
                    textSize = 16f
                    textColor = Color.WHITE
                }

                textView {
                    id = R.id.nextMatch_awayName
                    textSize = 16f
                    text="Indonesia"
                    textAlignment = LinearLayout.TEXT_ALIGNMENT_CENTER
                    textColor = Color.WHITE
                }.lparams {
                    width = matchParent
                    height = wrapContent
                    weight = 0.5f
                }

            }
        }

    }
}

class NextMatchViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val homeName: TextView = view.find(R.id.nextMatch_homeName)
    private val homeSkor: TextView = view.find(R.id.nextMatch_homeSkor)
    private val awayName: TextView = view.find(R.id.nextMatch_awayName)
    private val awaySkor: TextView = view.find(R.id.nextMatch_awaySkor)

    fun bindItem(event: Event){

        homeName.text = event.teamHome
        homeSkor.text = event.teamHomeScore.toString();if(homeSkor.text == null){homeSkor.text = "-"}
        awayName.text = event.teamAway
        awaySkor.text = event.teamAwayScore.toString();if(awaySkor.text == null){homeSkor.text = "-"}

    }
}