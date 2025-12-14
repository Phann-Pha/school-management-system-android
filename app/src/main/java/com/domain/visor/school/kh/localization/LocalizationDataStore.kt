package com.domain.visor.school.kh.localization

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalizationDataStore(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("local_language")
        val localizationKey = stringPreferencesKey("language")
    }

    val localization: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[localizationKey] ?: "en-US"
    }

    suspend fun update(value: String) {
        context.dataStore.edit { preferences -> preferences[localizationKey] = value }
    }
}