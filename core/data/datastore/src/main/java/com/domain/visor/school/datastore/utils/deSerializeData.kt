package com.domain.visor.school.datastore.utils

import com.google.gson.Gson

inline fun <reified T> deSerializeData(data: String): T
{
    return Gson().fromJson(data, T::class.java)
}