package com.common.ui

import android.view.View

object UtilitiesView {

    fun showOrHideView(view: View, needToShow: Boolean){
        if(needToShow){
            view.visibility = View.VISIBLE
        }else{
            view.visibility = View.GONE
        }
    }

}