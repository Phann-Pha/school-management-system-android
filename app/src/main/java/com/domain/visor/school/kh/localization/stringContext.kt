package com.domain.visor.school.kh.localization

import android.content.Context
import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import java.util.Locale

@Composable
fun Context.resource(lang: LocalizationDataStore): Resources {
    val tag = lang.value.collectAsStateWithLifecycle(initialValue = LocalState.ENG.value).value
    val local = Locale(tag ?: LocalState.ENG.value)
    Locale.setDefault(local)
    val config = resources.configuration
    config.setLocale(local)
    return createConfigurationContext(config).resources
}