package com.domain.visor.school.kh.base

import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.core.view.WindowCompat

open class BaseComponentActivity : ComponentActivity(), BaseComponentService
{
    override fun onChangeIconStatusBarColor(light: Boolean)
    {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        WindowCompat.getInsetsController(window, window.decorView).apply { isAppearanceLightStatusBars = light }
    }
}