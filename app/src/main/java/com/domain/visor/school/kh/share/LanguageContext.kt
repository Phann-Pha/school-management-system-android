package com.domain.visor.school.kh.share

import android.content.Context
import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.lifecycle.asLiveData
import com.domain.visor.school.datastore.LanguageSettingManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun Context.resource(lang: LanguageSettingManager): Resources {
    val config = resources.configuration
    CoroutineScope(context = Dispatchers.IO).launch {
        val tag = lang.value.asLiveData().value ?: lang.en
        val local = Locale(tag)
        Locale.setDefault(local)
        config.setLocale(local)
    }
    return createConfigurationContext(config).resources
}