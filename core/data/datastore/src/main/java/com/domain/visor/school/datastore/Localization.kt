package com.domain.visor.school.datastore

import android.content.Context
import java.util.Locale

class Localization(private val context: Context) {
    fun apply(code: String) {
        val locale = Locale(code)

    }
}