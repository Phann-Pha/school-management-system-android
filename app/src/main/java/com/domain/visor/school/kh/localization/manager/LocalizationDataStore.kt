package com.domain.visor.school.kh.localization.manager

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
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "local_language")
        private val key = stringPreferencesKey(name = "language")

        private const val EN = "en-US"
    }

    val value: Flow<String?> = context.dataStore.data.map { preferences -> preferences[key] ?: EN }

    suspend fun update(value: String) {
        context.dataStore.edit { preferences -> preferences[key] = value }
    }
}