package com.domain.visor.school.kh.share

import android.content.Context
import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.lifecycle.asLiveData
import com.domain.visor.school.datastore.LanguageSettingManager
import java.util.Locale

@Composable
fun Context.resource(lang: LanguageSettingManager): Resources {
    val config = resources.configuration
    val tag = lang.value.asLiveData().value ?: "en-US"
    val local = Locale(tag)
    Locale.setDefault(local)
    config.setLocale(local)
    return createConfigurationContext(config).resources
}