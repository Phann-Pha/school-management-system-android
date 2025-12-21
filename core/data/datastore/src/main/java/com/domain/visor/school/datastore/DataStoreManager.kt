package com.domain.visor.school.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.domain.visor.school.datastore.utils.deSerializeData
import com.domain.visor.school.datastore.utils.serializeData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(context: Context)
{
    companion object
    {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "app_pref")
    }

    val dataStore: DataStore<Preferences> = context.dataStore

    // store data as object
    suspend fun <T> storeObjectData(key: Preferences.Key<String>, value: T)
    {
        dataStore.edit { preferences -> preferences[key] = serializeData(data = value) }
    }

    // save primitives data
    suspend fun storeStringData(key: Preferences.Key<String>, value: String)
    {
        dataStore.edit { preferences -> preferences[key] = value }
    }

    suspend fun storeIntData(key: Preferences.Key<Int>, value: Int)
    {
        dataStore.edit { preferences -> preferences[key] = value }
    }

    suspend fun storeDoubleData(key: Preferences.Key<Double>, value: Double)
    {
        dataStore.edit { preferences -> preferences[key] = value }
    }

    suspend fun storeDoubleData(key: Preferences.Key<Float>, value: Float)
    {
        dataStore.edit { preferences -> preferences[key] = value }
    }

    suspend fun storeLongData(key: Preferences.Key<Long>, value: Long)
    {
        dataStore.edit { preferences -> preferences[key] = value }
    }

    suspend fun storeBooleanData(key: Preferences.Key<Boolean>, value: Boolean)
    {
        dataStore.edit { preferences -> preferences[key] = value }
    }

    // get data as object
    inline fun <reified T> getObjectData(key: Preferences.Key<String>): Flow<T>
    {
        return dataStore.data.map { deSerializeData(data = it[key] ?: "") }
    }

    // get primitives data
    fun getStringData(key: Preferences.Key<String>): Flow<String>
    {
        return dataStore.data.map { it[key] ?: "" }
    }

    fun getIntData(key: Preferences.Key<Int>): Flow<Int>
    {
        return dataStore.data.map { it[key] ?: 0 }
    }

    fun getDoubleData(key: Preferences.Key<Double>): Flow<Double>
    {
        return dataStore.data.map { it[key] ?: 0.0 }
    }

    fun getFloatData(key: Preferences.Key<Float>): Flow<Float>
    {
        return dataStore.data.map { it[key] ?: 0.0f }
    }

    fun getLongData(key: Preferences.Key<Long>): Flow<Long>
    {
        return dataStore.data.map { it[key] ?: 0 }
    }

    fun getBooleanData(key: Preferences.Key<Boolean>): Flow<Boolean>
    {
        return dataStore.data.map { it[key] ?: false }
    }
}