package com.namchok.core.common.base

import android.content.Context
import android.view.View
import androidx.navigation.NavController

interface ViewCommonActions {
    fun closeApp()

    fun getNavController(): NavController

    fun getUiView(): View

    fun getViewContext(): Context
}
