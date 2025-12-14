package com.domain.visor.school.kh.base

import android.content.Context
import android.content.res.Resources
import androidx.compose.runtime.Composable
import com.domain.visor.school.kh.localization.LocalizationDataStore

interface BaseComponentService {
    /** This property used for alternative language
     * */
    @Composable
    fun Context.resource(lang: LocalizationDataStore): Resources

    /** This function used for change icon status bar color.
     * @param isLightStatusBars if true icon status bar will be white else to gray
     * */
    fun onChangeIconStatusBarColor(isLightStatusBars: Boolean)
}