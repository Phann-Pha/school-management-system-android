package com.domain.visor.school.kh.share

import android.content.Context
import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.lifecycle.asLiveData
import java.util.Locale

@Composable
fun Context.resource(langCode: String): Resources {
    val config = resources.configuration
    val local = Locale(langCode)
    Locale.setDefault(local)
    config.setLocale(local)
    return createConfigurationContext(config).resources
}