package com.domain.visor.school.kh.features.language.presentation.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.visor.school.datastore.LanguageHelper
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SelectingLanguageScreenViewModel : ViewModel()
{
    private val languageHelper by lazy { LanguageHelper() }

    private val _loadingState: MutableLiveData<Boolean> = MutableLiveData()
    val loadingState: LiveData<Boolean> = _loadingState

    private val _changingState: MutableLiveData<Boolean> = MutableLiveData()
    val changingState: LiveData<Boolean> = _changingState

    fun onGetLanguageCode(context: Context): String
    {
        return languageHelper.getLanguageCode(context)
    }

    fun onChangedLanguage(context: Context, code: String)
    {
        _loadingState.postValue(true)
        viewModelScope.launch {
            delay(1000L)
            languageHelper.changeLanguage(context, code)
            _loadingState.postValue(false)
            _changingState.postValue(true)
        }
    }

    override fun onCleared()
    {
        super.onCleared()
        viewModelScope.cancel()
    }
}