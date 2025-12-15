package com.domain.visor.school.kh.features.onboard.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.domain.visor.school.datastore.LanguageSettingManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor() : ViewModel() {
    
    private val _uiState:  MutableLiveData<String> = MutableLiveData()
    val uiState: LiveData<String> = _uiState
    
    fun onAsyncDataInfo(lang: LanguageSettingManager) {
        lang.value.onEach { value ->
            if (value != null) _uiState.postValue(value)
        }.launchIn(viewModelScope)
    }
    
    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel()
    }
}