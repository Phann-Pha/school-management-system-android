package com.domain.visor.school.kh.base

import android.content.Context
import androidx.compose.runtime.Composable

interface BaseComponentService {
    /** This property used for alternative language
     * */
    @Composable
    fun stringContext(): Context

    /** This function used for change icon status bar color.
     * @param isLightStatusBars if true icon status bar will be white else to gray
     * */
    fun onChangeIconStatusBarColor(isLightStatusBars: Boolean)
}