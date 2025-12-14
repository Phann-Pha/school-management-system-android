package com.domain.visor.school.kh.base

import android.content.Context
import android.content.res.Resources
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.domain.visor.school.kh.localization.LocalState
import com.domain.visor.school.kh.localization.manager.LocalizationDataStore
import dagger.hilt.android.AndroidEntryPoint
import java.util.*

@AndroidEntryPoint
open class BaseComponentActivity : ComponentActivity(), BaseComponentService {

    protected val lang: LocalizationDataStore by lazy { LocalizationDataStore(context = this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @Composable
    override fun Context.resource(lang: LocalizationDataStore): Resources {
        val tag = lang.value.collectAsStateWithLifecycle(initialValue = LocalState.ENG.value).value
        val local = Locale(tag ?: LocalState.ENG.value)
        Locale.setDefault(local)
        val config = resources.configuration
        config.setLocale(local)
        return createConfigurationContext(config).resources
    }

    override fun onChangeIconStatusBarColor(isLightStatusBars: Boolean) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        WindowCompat.getInsetsController(window, window.decorView).apply {
            isAppearanceLightStatusBars = isLightStatusBars
        }
    }
}