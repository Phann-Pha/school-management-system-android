package com.domain.visor.school.kh.base

import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.core.view.WindowCompat
import com.domain.visor.school.datastore.LanguageSettingManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
open class BaseComponentActivity : ComponentActivity(), BaseComponentService {

    protected val lang: LanguageSettingManager by lazy { LanguageSettingManager(context = this) }

    override fun onChangeIconStatusBarColor(light: Boolean) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        WindowCompat.getInsetsController(window, window.decorView).apply { isAppearanceLightStatusBars = light }
    }
}