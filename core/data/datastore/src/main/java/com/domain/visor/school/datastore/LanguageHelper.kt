package com.domain.visor.school.datastore

import android.app.LocaleManager
import android.content.Context
import android.content.res.Configuration
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import java.util.Locale

class LanguageHelper
{
    fun changeLanguage(context: Context, languageCode: String)
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        {
            // Android 13+: Use LocaleManager for per-app persistence
            val localeManager = context.getSystemService(LocaleManager::class.java)
            localeManager.applicationLocales = LocaleList.forLanguageTags(languageCode)
        }
        else
        {
            // Pre-Android 13: Use AppCompatDelegate
            val locales = LocaleListCompat.forLanguageTags(languageCode)
            AppCompatDelegate.setApplicationLocales(locales)
        }

        // Immediate update for resources (affects View-based UI)
        val config = Configuration(context.resources.configuration)
        config.setLocale(Locale(languageCode))
        context.resources.updateConfiguration(config, context.resources.displayMetrics)
    }

    fun getLanguageCode(context: Context): String
    {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
        {
            // Android 13+: Use LocaleManager for per-app persistence
            val localeManager = context.getSystemService(LocaleManager::class.java)
            localeManager.applicationLocales[0]?.toLanguageTag()?.split("-")?.first() ?: "en"
        }
        else
        {
            // Pre-Android 13: Use AppCompatDelegate
            val locales = AppCompatDelegate.getApplicationLocales()
            locales[0]?.toLanguageTag()?.split("-")?.first() ?: "en"
        }
    }
}