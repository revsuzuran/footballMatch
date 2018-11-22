/*
 * Created On : 10/25/18 10:03 PM
 * Author : Aqil Prakoso
 * Copyright (c) 2018 iRevStudio
 *
 */

package com.irevstudio.footballschedule.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.irevstudio.footballschedule.ui.lastmatch.LastMatch
import com.irevstudio.footballschedule.ui.nextmatch.NextMatch
import com.irevstudio.footballschedule.ui.team.TeamFragment

class TabAdapter (fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            LastMatch()
        } else if(position == 1){
            NextMatch()
        } else{
            TeamFragment()
        }

    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Last Match"
            1 -> "Next Match"
            else -> "Teams"
        }
    }
}