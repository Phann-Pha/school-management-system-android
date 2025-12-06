package com.domain.visor.school.kh.common

import android.content.Context

object MobileSystem {

    fun onSaveLocalStorage(context: Context, key: String, value: String) {
        val pref = context.getSharedPreferences("myPref", Context.MODE_PRIVATE)
        pref.edit().putString(key, value).apply()
    }

    fun onGetLocalStorage(context: Context, key: String): String {
        val pref = context.getSharedPreferences("myPref", Context.MODE_PRIVATE)
        val data = pref.getString(key, "")
        return data.orEmpty()
    }
}