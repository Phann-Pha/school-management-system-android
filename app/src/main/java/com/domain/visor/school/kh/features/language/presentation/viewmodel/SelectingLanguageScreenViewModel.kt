package com.domain.visor.school.kh.features.language.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.visor.school.datastore.LanguageHelper
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class SelectingLanguageScreenViewModel : ViewModel()
{
    private val languageHelper by lazy { LanguageHelper() }

    private val _onChangedLanguageState: MutableLiveData<Boolean> = MutableLiveData()
    val onChangedLanguageState: LiveData<Boolean> = _onChangedLanguageState

    fun onGetLanguageCode(context: Context): String
    {
        return languageHelper.getLanguageCode(context)
    }

    fun onChangedLanguage(context: Context, code: String)
    {
        viewModelScope.launch {
            languageHelper.changeLanguage(context, code)
        }
        _onChangedLanguageState.value = true
    }

    override fun onCleared()
    {
        super.onCleared()
        viewModelScope.cancel()
    }
}