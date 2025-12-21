package com.domain.visor.school.datastore.utils

import com.google.gson.Gson

fun <T> serializeData(data: T): String
{
    return Gson().toJson(data)
}